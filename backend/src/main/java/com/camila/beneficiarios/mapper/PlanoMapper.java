package com.camila.beneficiarios.mapper;


import com.camila.beneficiarios.dtos.PageableDTO;
import com.camila.beneficiarios.dtos.PlanoDTO;
import com.camila.beneficiarios.model.entity.Beneficiario;
import com.camila.beneficiarios.model.entity.Plano;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class PlanoMapper {

    public static PlanoDTO toPlanoDTO( Plano service ) {
        return PlanoDTO.builder()
                .id( service.getId() )
                .nome( service.getNome() )
                .valor( service.getValor() )
                .build();


    }


    public static Plano toPlano( PlanoDTO planoDTO ) {


        return Plano.builder()
                .id( planoDTO.getId() )
                .nome( planoDTO.getNome() )
                .valor(  planoDTO.getValor()  )
                .build();


    }

    public static BigDecimal converter(String value) {
        if( Objects.isNull( value ) ) {
            return null;
        }
        value = value.replace( ".", "" ).replace( ",", "." );
        return new BigDecimal( value );
    }

    public static PlanoDTO userDetailsDto( String nome ) {
        return PlanoDTO.builder()
                .nome( nome )
                .build();
    }

    public static Plano userDetailsDtos( String nome ) {
        return Plano.builder()
                .nome( nome )
                .build();
    }


    public static Pageable getPageable( PageableDTO pageableDto ) {
        return PageRequest.of( pageableDto.getPageNumber(), pageableDto.getPageSize(),
                Sort.Direction.fromString( pageableDto.getSortDirection() ), pageableDto.getSortField() );
    }
}
