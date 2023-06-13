package br.cefet.dbf.petshop.repository;

import br.cefet.dbf.petshop.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
