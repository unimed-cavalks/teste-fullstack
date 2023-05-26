package unimed.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unimed.model.entity.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer>{
}
