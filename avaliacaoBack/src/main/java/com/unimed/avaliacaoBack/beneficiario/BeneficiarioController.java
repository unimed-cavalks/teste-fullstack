package com.unimed.avaliacaoBack.beneficiario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping
    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioService.listarBeneficiarios();
    }

    @GetMapping("/{id}")
    public Optional<Beneficiario> buscarBeneficiario(@PathVariable Long id) {
        return beneficiarioService.buscarBeneficiario(id);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Beneficiario salvarBeneficiario(@RequestBody Beneficiario beneficiario) {
        return beneficiarioService.salvarBeneficiario(beneficiario);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void atualizarBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        beneficiario.setId(id);
        beneficiarioService.atualizarBeneficiario(beneficiario);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletarBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
    }
}

        