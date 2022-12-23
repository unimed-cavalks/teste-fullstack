package com.camila.beneficiarios.model.service;

import com.camila.beneficiarios.dtos.UsuarioDTO;
import com.camila.beneficiarios.mapper.UserMapper;
import com.camila.beneficiarios.model.entity.Usuario;
import com.camila.beneficiarios.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Usuario saveUser( UsuarioDTO userDTO ) {
        Usuario user;
        if( userRepository.findByLogin( userDTO.getLogin()).isPresent() ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "Esse login "  + userDTO.getLogin() + " já está sendo usado." );
        }
        user = userRepository.save( UserMapper.toUser( userDTO ) );
        return user;
    }
}
