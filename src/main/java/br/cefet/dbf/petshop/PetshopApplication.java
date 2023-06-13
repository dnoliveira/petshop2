package br.cefet.dbf.petshop;

import br.cefet.dbf.petshop.model.Ordem;
import br.cefet.dbf.petshop.model.Pet;
import br.cefet.dbf.petshop.model.Servico;
import br.cefet.dbf.petshop.repository.OrdemRepository;
import br.cefet.dbf.petshop.repository.PetRepository;
import br.cefet.dbf.petshop.repository.ServicoRepository;
import br.cefet.dbf.petshop.service.OrdemService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PetshopApplication implements ApplicationRunner {
	@Autowired
	private PetRepository petRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private OrdemRepository ordemRepository;

	@Autowired
	private OrdemService ordemService;

	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// INSERIR PETs
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

		// INSERIR Servicos
		Servico serv1 = Servico.builder().descricao("Tosa").valor(new BigDecimal(50.0)).build();
		Servico serv2 = Servico.builder().descricao("Banho").valor(new BigDecimal(30)).build();
		serv1 = servicoRepository.save(serv1);
		serv2 = servicoRepository.save(serv2);
		System.out.println(serv1);
		System.out.println(serv2);
		System.out.println(pet1);
		System.out.println(pet2);

		//Ordem de servico
		List<Servico> servicoList = new ArrayList<>();
		servicoList.add(serv1);
		servicoList.add(serv2);
		Ordem ordem = Ordem.builder()
				.dtOrdem(Instant.parse("2022-05-13T00:00:00.00Z"))
				.pet(pet1)
				.servicos(servicoList)
				.build();
		ordemRepository.save(ordem); //Erro pois valor não tem informacao.
		//ordemService.save(ordem);

		/*
		 * ordem = ordemRepository.save(ordem);
		 *
		 * List<Servico> servicoList = new ArrayList<Servico>();
		 * servicoList.add(serv1);
		 * servicoList.add(serv2);
		 * for (Servico servico : servicoList) {
		 * OrdemServico ordemServico = new OrdemServico();
		 * ordemServico.setOrdem(ordem);
		 * ordemServico.setServico(servico);
		 * ordemServico.setValor(servico.getValor());
		 * ordemServicoRepository.save(ordemServico);
		 * }
		 */
	}

}
