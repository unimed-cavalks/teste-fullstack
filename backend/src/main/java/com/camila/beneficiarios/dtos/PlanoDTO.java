package com.camila.beneficiarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanoDTO {
    private Long id;
    @NotEmpty( message =  "{MSG004}" )
    private String nome;
    @NotEmpty( message = "{MSG005}")
    private String valor;

}
