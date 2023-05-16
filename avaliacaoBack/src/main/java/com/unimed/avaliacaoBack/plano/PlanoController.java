package com.unimed.avaliacaoBack.plano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planos")
public class PlanoController {
    private final PlanoService planoService;

    @Autowired
    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public List<Plano> listarPlanos() {
        return planoService.listarPlanos();
    }

    @GetMapping("/{id}")
    public Optional<Plano> buscarPlano(@PathVariable Long id) {
        return planoService.buscarPlano(id);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Plano salvarPlano(@RequestBody Plano plano) {
        return planoService.salvarPlano(plano);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void atualizarPlano(@PathVariable Long id, @RequestBody Plano plano) {
        plano.setId(id);
        planoService.atualizarPlano(plano);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
    }
}
