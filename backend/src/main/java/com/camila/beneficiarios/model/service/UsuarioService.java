package com.camila.beneficiarios.model.service;

import com.camila.beneficiarios.model.entity.Usuario;
import com.camila.beneficiarios.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String login ) throws UsernameNotFoundException {
        Usuario user = userRepository.findByLogin( login )
                .orElseThrow( () -> new UsernameNotFoundException( "Login não encontrado." )  );

        return org.springframework.security.core.userdetails.User
                .builder()
                .username( user.getLogin() )
                .password( user.getSenha() )
                .roles( "USER" )
                .build();
    }
}
