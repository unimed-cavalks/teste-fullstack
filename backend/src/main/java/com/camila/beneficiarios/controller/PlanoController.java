package com.camila.beneficiarios.controller;


import com.camila.beneficiarios.dtos.BeneficiarioDTO;
import com.camila.beneficiarios.dtos.PageableDTO;
import com.camila.beneficiarios.dtos.PlanoDTO;
import com.camila.beneficiarios.mapper.BeneficiarioMapper;
import com.camila.beneficiarios.mapper.PlanoMapper;
import com.camila.beneficiarios.model.entity.Beneficiario;
import com.camila.beneficiarios.model.entity.Plano;
import com.camila.beneficiarios.model.service.PlanoService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {

    @Autowired
    private PlanoService service;


    @PostMapping
    public ResponseEntity< Plano > saveService( @RequestBody  @Valid PlanoDTO planoDTO ) {
        final Plano plano = service.save( planoDTO );
        return new ResponseEntity( plano, HttpStatus.CREATED );
    }


    @GetMapping
    public ResponseEntity findAllService ( @RequestParam( required = false ) String nome,
                                                              PageableDTO pageableDTO ) {

        Pageable pageable = PlanoMapper.getPageable( pageableDTO );

        Page< Plano > pageService = service.findAllService(  nome, pageable );
        return new ResponseEntity( pageService.getContent(), HttpStatus.OK ) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity < PlanoDTO > findPlanoById( @PathVariable Long id ) {
        Plano plano = service.findPlanoById( id );
        PlanoDTO planoDTO = PlanoMapper.toPlanoDTO( plano );
        return new ResponseEntity( planoDTO, HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public void updatePlano( @PathVariable Long id, @RequestBody PlanoDTO planoDTO ) {
        System.out.println(String.format("Plano updated: %s", planoDTO.toString()));
        service.updatePlano( id, planoDTO );

    }

    @DeleteMapping("/{id}")
    public void deletePlano ( @PathVariable Long id) {
        service.deletePlano( id );
    }


}
