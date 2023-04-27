package br.edu.ifrs.riogrande.tads.cobaia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.cobaia.entity.Aluno;

public interface AlunoRepository // <TipoEntidade, TipoId>
                extends CrudRepository<Aluno, Long> {
  
}

