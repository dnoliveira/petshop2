package br.cefet.dbf.petshop.repository;

import br.cefet.dbf.petshop.model.OrdemServico;
import br.cefet.dbf.petshop.model.OrdemServicoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, OrdemServicoId> {

}
