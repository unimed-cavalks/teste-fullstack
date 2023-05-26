package unimed.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unimed.model.entity.PlanoPrestado;
import unimed.model.repository.BeneficiarioRepository;
import unimed.model.repository.PlanoPrestadoRepository;
import unimed.rest.dto.PlanoPrestadoDTO;
import unimed.model.entity.PlanoPrestado;

@RestController
@RequestMapping("/api/planos-prestados")
@RequiredArgsConstructor
public class PlanoPrestadoController {

    private final BeneficiarioRepository beneficiarioRepository;
    private final PlanoPrestadoRepository repository;

    @PostMapping
    public PlanoPrestado salvar(@RequestBody PlanoPrestadoDTO dto){

        PlanoPrestado planoPrestado = new PlanoPrestado();
        return planoPrestado;

    }
}
