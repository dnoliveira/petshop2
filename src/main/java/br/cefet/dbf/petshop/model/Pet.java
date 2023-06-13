package br.cefet.dbf.petshop.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 35, nullable = false)
    private String nome;

    @Column(name = "dono", length = 60, nullable = false)
    private String dono;

    @Column(name = "raca", length = 35, nullable = false)
    private String raca;

    @Column(name = "peso", nullable = true)
    private double peso;
}
