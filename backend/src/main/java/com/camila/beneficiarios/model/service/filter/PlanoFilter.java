package com.camila.beneficiarios.model.service.filter;

import com.camila.beneficiarios.dtos.PlanoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class PlanoFilter {

    private String nome;

    public static PlanoFilter of( PlanoDTO planoDTO ) {
        return PlanoFilter.builder()
                .nome( planoDTO.getNome() )
                .build();
    }
}
