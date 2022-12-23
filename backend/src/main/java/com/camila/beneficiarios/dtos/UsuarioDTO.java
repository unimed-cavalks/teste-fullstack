package com.camila.beneficiarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    @NotEmpty( message = "{MSG001}")
    private String nome;
    @NotEmpty( message = "{MSG007}")
    private String login;
    @NotEmpty( message = "{MSG008}")
    private String senha;
}
