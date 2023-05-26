package unimed.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PlanoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_beficiario")
    private Beneficiario beneficiario;
}
