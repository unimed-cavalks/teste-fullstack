package com.camila.beneficiarios.controller;

import com.camila.beneficiarios.dtos.UsuarioDTO;
import com.camila.beneficiarios.mapper.UserMapper;
import com.camila.beneficiarios.model.entity.Usuario;
import com.camila.beneficiarios.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity< UsuarioDTO > saveUser( @Valid @RequestBody UsuarioDTO userDTO ) {
        final Usuario user = userService.saveUser(userDTO);
        System.out.println(String.format("Beneficiario saved: %s", user.toString()));
        return new ResponseEntity( UserMapper.toUserDTO( user ), HttpStatus.CREATED );

    }
}
