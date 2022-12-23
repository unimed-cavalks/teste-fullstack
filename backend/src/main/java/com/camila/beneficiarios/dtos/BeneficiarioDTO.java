package com.camila.beneficiarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarioDTO {

    private Long id;

    @NotEmpty( message = "{MSG001}")
    private String nome;

    @NotNull( message = "{MSG002}")
    @CPF(message = "{MSG003}")
    private String cpf;

    @NotNull( message = "{MSG010}")
    @Email( message = "{MSG011}")
    private String email;

    @NotNull( message = "{MSG009}")
    private Integer idade;

}
