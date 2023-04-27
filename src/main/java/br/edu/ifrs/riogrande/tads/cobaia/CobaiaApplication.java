package br.edu.ifrs.riogrande.tads.cobaia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifrs.riogrande.tads.cobaia.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.repository.AlunoRepository;
import br.edu.ifrs.riogrande.tads.cobaia.service.AlunoService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CobaiaApplication {
	// Injeção de Dependências (DI - Dependency Injection)

	@Autowired
	private AlunoRepository alunoRepository;


	@Autowired
	private AlunoService alunoService;

	public static void main(String[] args) {
		System.out.println("Algo");
		SpringApplication.run(CobaiaApplication.class, args);
	}

	@PostConstruct
	void popularBanco() {
		System.out.println("Populando o mochinho ...");

		Aluno a = new Aluno();
		a.setNome("Marcio");
		a.setEmail("marcio.torres@riogrande.ifrs.edu.br");

		a = alunoRepository.save(a);

		System.out.println(alunoRepository.getClass());

		System.out.println("Aluno salvo " + a.getId());

		System.out.println(alunoService.getAlunos());
	}
}
