package br.cefet.dbf.petshop;

import br.cefet.dbf.petshop.model.Pet;
import br.cefet.dbf.petshop.repository.PetRepository;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetshopApplication implements ApplicationRunner {
	@Autowired
	private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Pet pet1 = Pet.builder()
				.id(1L)
				.nome("Spike")
				.dono("Gabriella")
				.raca("Vira lata")
				.build();
		Pet pet2 = Pet.builder()
				.id(2L)
				.nome("Bidu")
				.dono("Monica")
				.raca("Pitbull")
				.build();
		pet1 = petRepository.save(pet1);
		pet2 = petRepository.save(pet2);
		System.out.println(pet1);
		System.out.println(pet2);
	}

}
