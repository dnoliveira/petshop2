package br.cefet.dbf.petshop.repository;

import br.cefet.dbf.petshop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
