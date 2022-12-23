package com.camila.beneficiarios.model.repository;

import com.camila.beneficiarios.model.entity.Beneficiario;
import com.camila.beneficiarios.model.service.filter.BeneficiarioFilter;
import com.camila.beneficiarios.model.service.specification.ClientSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@Repository
public interface BeneficiarioRepository extends JpaRepository< Beneficiario, Long >, JpaSpecificationExecutor< Beneficiario > {
    Optional< Beneficiario > findClientByCpf( String cpf );

    default Page< Beneficiario > getAll( BeneficiarioFilter filter, Pageable pageable ) {
        Specification spec = where( ClientSpecification.cpf( filter.getCpf() ) )
                .and( ClientSpecification.nome( filter.getNome() ) );
        return findAll( spec, pageable );
    }
}
