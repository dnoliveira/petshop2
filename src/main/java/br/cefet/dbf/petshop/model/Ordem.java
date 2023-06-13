package br.cefet.dbf.petshop.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

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

    @Column(nullable = false)
    private Instant dtOrdem;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_pet", nullable = false, foreignKey = @ForeignKey(name = "fk_ordem_pet"))
    private Pet pet;

    @ManyToMany
    @JoinTable(name = "ordem_servico", joinColumns = {@JoinColumn(name = "ordem_id")}, inverseJoinColumns = {
            @JoinColumn(name = "servico_id")})
    private List<Servico> servicos = new ArrayList<>();

}
