package com.camila.beneficiarios.controller;

import com.camila.beneficiarios.dtos.BeneficiarioDTO;
import com.camila.beneficiarios.dtos.PageableDTO;
import com.camila.beneficiarios.mapper.BeneficiarioMapper;
import com.camila.beneficiarios.model.entity.Beneficiario;
import com.camila.beneficiarios.model.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;


    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public ResponseEntity< BeneficiarioDTO > saveBeneficiario( @Valid @RequestBody BeneficiarioDTO beneficiarioDTO ) throws Exception {
    final Beneficiario beneficiario = service.saveBeneficiario( beneficiarioDTO );
    System.out.println(String.format("Beneficiario saved: %s", beneficiario.toString()));
    return new ResponseEntity( BeneficiarioMapper.toBeneficiarioDTO( beneficiario ), HttpStatus.CREATED );

    }

    @GetMapping
    public ResponseEntity findAllBeneficiario ( @RequestParam( required = false ) String cpf,
                                          @RequestParam( required = false) String nome, PageableDTO pageableDTO ) {

        Pageable pageable = BeneficiarioMapper.getPageable( pageableDTO );

            Page< Beneficiario > pageClient = service.findAllUser(  cpf, nome, pageable );
            return new ResponseEntity( pageClient.getContent(), HttpStatus.OK ) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity < BeneficiarioDTO > findBeneficiarioById( @PathVariable Long id ) {
        Beneficiario beneficiario = service.findBeneficiarioById( id );
        BeneficiarioDTO beneficiarioDTO = BeneficiarioMapper.toBeneficiarioDTO( beneficiario );
        return new ResponseEntity( beneficiarioDTO, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiario ( @PathVariable Long id) {
        service.deleteBeneficiario( id );
    }


    @PutMapping("/{id}")
    public void updateBeneficiario( @PathVariable Long id, @RequestBody BeneficiarioDTO beneficiarioDTO ) {
        System.out.println(String.format("Beneficiario updated: %s", beneficiarioDTO.toString()));
        service.updateBeneficiario( id, beneficiarioDTO );

    }

}
