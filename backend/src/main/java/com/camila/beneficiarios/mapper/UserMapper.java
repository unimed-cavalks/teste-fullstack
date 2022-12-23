package com.camila.beneficiarios.mapper;


import com.camila.beneficiarios.dtos.UsuarioDTO;
import com.camila.beneficiarios.model.entity.Usuario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class UserMapper {

    public static Usuario toUser( UsuarioDTO userDTO ) {
        return Usuario.builder()
                .id( userDTO.getId() )
                .nome( userDTO.getNome() )
                .login( userDTO.getLogin() )
                .senha( userDTO.getSenha() )
                .build();
    }

    public static UsuarioDTO toUserDTO( Usuario user ) {
        return UsuarioDTO.builder()
                .id( user.getId() )
                .nome( user.getNome() )
                .login( user.getLogin() )
                .senha( user.getSenha() )
                .build();
    }
}
