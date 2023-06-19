package br.cefet.dbf.petshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idOrdem;
    private Long idServico;

}
