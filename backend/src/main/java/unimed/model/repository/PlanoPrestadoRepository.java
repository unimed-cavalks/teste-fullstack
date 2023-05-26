package unimed.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unimed.model.entity.PlanoPrestado;

public interface PlanoPrestadoRepository extends JpaRepository<PlanoPrestado, Integer> {
}
