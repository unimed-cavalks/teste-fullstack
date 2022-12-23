package com.camila.beneficiarios.model.service;

import com.camila.beneficiarios.dtos.BeneficiarioDTO;
import com.camila.beneficiarios.mapper.BeneficiarioMapper;
import com.camila.beneficiarios.model.entity.Beneficiario;
import com.camila.beneficiarios.model.repository.BeneficiarioRepository;
import com.camila.beneficiarios.model.service.filter.BeneficiarioFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    public Beneficiario saveBeneficiario( BeneficiarioDTO beneficiarioDTO ) {
        Beneficiario beneficiario;
        if( repository.findClientByCpf( beneficiarioDTO.getCpf() ).isPresent() ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "CPF já cadastrado" );
        }

        beneficiario = repository.save( BeneficiarioMapper.toBeneficiario( beneficiarioDTO ) );
        return beneficiario;
    }

    public Page< Beneficiario > findAllUser( String cpf, String nome, Pageable pageable ) {
        Page < Beneficiario > beneficiarios = Optional.of( repository.getAll( BeneficiarioFilter.of( BeneficiarioMapper.userDetailsDto( cpf, nome ) ), pageable ) )
                .orElse( null );
        return new PageImpl( beneficiarios.map( f -> BeneficiarioMapper.toBeneficiarioDTO( f ) ).getContent(),
                pageable, beneficiarios.getTotalElements() );
    }


    public Beneficiario findBeneficiarioById( Long id ) {
        return repository.findById( id )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }

    public void deleteBeneficiario( Long id ) {
        repository.findById( id ).map( client -> {
            repository.delete( client );
            return Void.TYPE;
        } ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }

    public void updateBeneficiario( Long id, BeneficiarioDTO beneficiarioDTO ) {

        repository.findById( id ).map( beneficiario -> {
            beneficiario.setNome( beneficiarioDTO.getNome() );
            beneficiario.setEmail( beneficiarioDTO.getEmail() );
            beneficiario.setIdade( beneficiarioDTO.getIdade() );
            return repository.save( beneficiario );
        } ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NO_CONTENT ) );
    }
}
