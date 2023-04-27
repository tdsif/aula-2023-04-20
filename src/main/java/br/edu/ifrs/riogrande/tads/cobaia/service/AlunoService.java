package br.edu.ifrs.riogrande.tads.cobaia.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.cobaia.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.repository.AlunoRepository;

@Service
public class AlunoService {

  private AlunoRepository alunoRepository;

  public AlunoService(AlunoRepository alunoRepository) {
    this.alunoRepository = alunoRepository;
  }

  public Iterable<Aluno> getAlunos() {
    return alunoRepository.findAll();
  }

  public Optional<Aluno> findById(@NonNull Long id) {
    return alunoRepository.findById(id);
  }

  public void salvar(Aluno aluno) {
    if (aluno == null) {
      throw new NullPointerException("Necessário o body da requisição");
    }
    if (aluno.getNome() == null) {
      throw new IllegalArgumentException("O campo nomeCompleto é obrigatório");
    }
    if (aluno.getEmail() == null) {
      throw new IllegalArgumentException("O campo email é obrigatório");
    }
    alunoRepository.save(aluno);
  }
  

  public void excluir(Long id) {

    Aluno aluno = alunoRepository.findById(id)
      .orElseThrow(() -> new IllegalStateException("Aluno não existe"));

    alunoRepository.delete(aluno);
  }
}
