package com.camila.beneficiarios.mapper;


import com.camila.beneficiarios.dtos.BeneficiarioDTO;
import com.camila.beneficiarios.dtos.PageableDTO;
import com.camila.beneficiarios.model.entity.Beneficiario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class BeneficiarioMapper {

    public static BeneficiarioDTO toBeneficiarioDTO( Beneficiario beneficiario ) {
        return BeneficiarioDTO.builder()
                .id( beneficiario.getId() )
                .cpf( beneficiario.getCpf() )
                .nome( beneficiario.getNome() )
                .email( beneficiario.getEmail() )
                .idade( beneficiario.getIdade() )
                .build();
    }

    public static Beneficiario toBeneficiario( BeneficiarioDTO beneficiarioDTO ) {
        return Beneficiario.builder()
                .id( beneficiarioDTO.getId() )
                .cpf( beneficiarioDTO.getCpf() )
                .nome( beneficiarioDTO.getNome() )
                .email( beneficiarioDTO.getEmail()  )
                .idade( beneficiarioDTO.getIdade() )
                .build();
    }

    public static BeneficiarioDTO userDetailsDto( String cpf, String nome ) {
        return BeneficiarioDTO.builder()
                .cpf(  cpf )
                .nome( nome )
                .build();
    }

    public static Pageable getPageable( PageableDTO pageableDto ) {
        return PageRequest.of( pageableDto.getPageNumber(), pageableDto.getPageSize(),
                Sort.Direction.fromString( pageableDto.getSortDirection() ), pageableDto.getSortField() );
    }
}
