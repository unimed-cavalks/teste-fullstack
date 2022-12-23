package com.camila.beneficiarios.model.repository;

import com.camila.beneficiarios.model.entity.Plano;
import com.camila.beneficiarios.model.service.filter.PlanoFilter;
import com.camila.beneficiarios.model.service.specification.ServiceRenderedSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import static org.springframework.data.jpa.domain.Specification.where;

@Repository
public interface PlanoRepository extends JpaRepository< Plano, Long >, JpaSpecificationExecutor< Plano > {
    default Page< Plano > getAll( PlanoFilter filter, Pageable pageable ) {
        Specification spec = where( ServiceRenderedSpecification.nome( filter.getNome() ));
        return findAll( spec, pageable );
    }

}
