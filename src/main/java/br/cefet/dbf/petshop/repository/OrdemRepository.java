package br.cefet.dbf.petshop.repository;

import br.cefet.dbf.petshop.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {
    List<Ordem> findByIdPetOrderByDtOrdem (Long idPet);
}
