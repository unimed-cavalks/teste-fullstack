package com.camila.beneficiarios.model.service;

import com.camila.beneficiarios.dtos.PlanoDTO;
import com.camila.beneficiarios.mapper.PlanoMapper;
import com.camila.beneficiarios.model.entity.Plano;
import com.camila.beneficiarios.model.repository.BeneficiarioRepository;
import com.camila.beneficiarios.model.repository.PlanoRepository;
import com.camila.beneficiarios.model.service.filter.PlanoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;


    public Plano save( PlanoDTO planoDTO ) {
        Plano plano = new Plano();
        plano = planoRepository.save( PlanoMapper.toPlano( planoDTO ) );
        return plano;
    }

    public Page< Plano > findAllService(  String nome, Pageable pageable ) {
        Page < Plano > services = Optional.of( planoRepository.getAll( PlanoFilter.of( PlanoMapper.userDetailsDto( nome ) ), pageable ) )
                .orElse( null );
        return new PageImpl( services.map( f -> f ).getContent(),
                pageable, services.getTotalElements() );
    }

    public Plano findPlanoById( Long id ) {
        return planoRepository.findById( id )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }

    public void updatePlano( Long id, PlanoDTO planoDTO ) {

        planoRepository.findById( id ).map( plano -> {
            plano.setNome( planoDTO.getNome() );
            plano.setValor( planoDTO.getValor() );
            return planoRepository.save( plano );
        } ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NO_CONTENT ) );
    }

    public void deletePlano( Long id ) {
        planoRepository.findById( id ).map( plano -> {
            planoRepository.delete( plano );
            return Void.TYPE;
        } ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }
}
