package br.cefet.dbf.petshop.model;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(OrdemServicoId.class)
@Entity(name = "ordem_servico")
public class OrdemServico {
    @Id
    private Long idOrdem;

    @Id
    private Long idServico;

    @Column(nullable = false)
    private BigDecimal valor;
}
