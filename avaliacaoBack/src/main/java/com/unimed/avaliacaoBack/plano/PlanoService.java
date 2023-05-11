package com.unimed.avaliacaoBack.plano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    private final PlanoRepository PlanoRepository;

    @Autowired
    public PlanoService(PlanoRepository PlanoRepository) {
        this.PlanoRepository = PlanoRepository;
    }

    public List<Plano> listarPlanos() {
        return PlanoRepository.findAll();
    }

    public Optional<Plano> buscarPlano(Long id) {
        return PlanoRepository.findById(id);
    }

    public Plano salvarPlano(Plano Plano) {
        return PlanoRepository.save(Plano);
    }

    public void atualizarPlano(Plano Plano) {
        PlanoRepository.save(Plano);
    }

    public void deletarPlano(Long id) {
        PlanoRepository.deleteById(id);
    }
}