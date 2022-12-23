package com.camila.beneficiarios.model.service.specification;

import com.camila.beneficiarios.model.entity.Plano;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import java.util.Objects;

@UtilityClass
public class ServiceRenderedSpecification {

    public Specification< Plano > nome( String nome ) {
        return ( root, criteriaQuery, criteriaBuilder ) -> {
            if( Objects.isNull( nome ) ) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal( root.get( "nome" ), nome );
        };
    }

}
