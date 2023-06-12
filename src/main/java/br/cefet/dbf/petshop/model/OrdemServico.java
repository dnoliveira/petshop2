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
@Entity(name = "ordem_servico")
public class OrdemServico {

    @EmbeddedId
    private OrdemServicoId id = new OrdemServicoId();

    @ManyToOne
    @MapsId("idOrdem")
    private Ordem ordem;

    @ManyToOne
    @MapsId("idServico")
    private Servico servico;

    @Column(nullable = false)
    private BigDecimal valor;
}
