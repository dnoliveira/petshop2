package br.cefet.dbf.petshop.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    private int id;
    private String nome;
    private String dono;
    private String raca;
    private double peso;
}
