package unimed.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanoPrestadoDTO {
    private String nome;
    private String preco;
    private Integer idBeneficiario;
}
