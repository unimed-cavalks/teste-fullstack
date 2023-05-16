package com.unimed.avaliacaoBack.beneficiario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {
    private final BeneficiarioRepository beneficiarioRepository;

    //@Autowired
    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Optional<Beneficiario> buscarBeneficiario(Long id) {
        return beneficiarioRepository.findById(id);
    }

    public Beneficiario salvarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public void atualizarBeneficiario(Beneficiario beneficiario) {
        beneficiarioRepository.save(beneficiario);
    }

    public void deletarBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}
