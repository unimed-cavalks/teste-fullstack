package com.camila.beneficiarios.model.service.specification;

import com.camila.beneficiarios.model.entity.Beneficiario;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;
@UtilityClass
public class ClientSpecification {

        public Specification< Beneficiario > cpf( String cpf ) {
            return ( root, criteriaQuery, criteriaBuilder ) -> {
                if( Objects.isNull( cpf ) ) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.equal( root.get( "cpf" ), cpf );
            };
        }

        public Specification< Beneficiario > nome( String nome ) {
            return ( root, criteriaQuery, criteriaBuilder ) -> {
                if( Objects.isNull( nome ) ) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.equal( root.get( "nome" ), nome );
            };
        }

}
