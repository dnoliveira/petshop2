package br.cefet.dbf.petshop.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ordem")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idPet;

    @Column(nullable = false)
    private Instant dtOrdem;
    private String observacao;

    @Transient
    private Pet pet;

    @Transient
    private List<Servico> servicos = new ArrayList<>();
}
