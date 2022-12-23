package com.camila.beneficiarios.model.service.filter;

import com.camila.beneficiarios.dtos.BeneficiarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@AllArgsConstructor
@Getter
public class BeneficiarioFilter {

    private String cpf;
    private String nome;

    public static BeneficiarioFilter of( BeneficiarioDTO beneficiarioDTO ) {
        return BeneficiarioFilter.builder()
                .cpf( beneficiarioDTO.getCpf() )
                .nome( beneficiarioDTO.getNome() )
                .build();
    }
}
