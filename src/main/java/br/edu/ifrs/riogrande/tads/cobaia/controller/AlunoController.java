package br.edu.ifrs.riogrande.tads.cobaia.controller;

import static java.util.Objects.requireNonNull;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import br.edu.ifrs.riogrande.tads.cobaia.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.service.AlunoService;

@RestController
@RequestMapping("/api/v1/alunos") // resource (recurso) => plural
public class AlunoController {
  
  private final AlunoService alunoService;

  public AlunoController(AlunoService alunoService) {
    this.alunoService = alunoService;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> excluir(@PathVariable Long id) {

    try {
      alunoService.excluir(id);
      return ResponseEntity.ok().build(); // 200
    } catch (IllegalStateException e) {
      // return ResponseEntity.notFound().build();
      return ResponseEntity.noContent().build(); // 204 -> cacheável-repetível
    }

  }

  @PostMapping
  public ResponseEntity<?> novoAluno(@RequestBody Aluno aluno) {
    try {
      alunoService.salvar(aluno);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

    // http://localhost:9090/api/v1/alunos/{id}
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(aluno.getId())
      .toUri();

    return ResponseEntity.created(location).build(); // 201 CREATED Location: URL do recurso criado
  }


  @GetMapping
  public Iterable<Aluno> getAlunos() {
    return alunoService.getAlunos();
  }

  @GetMapping("/{id}") // ex.: /alunos?id=1 (? query param) ou /alunos/1 (recurso com uma identidade)
  public ResponseEntity<Aluno> getAluno(@PathVariable("id") Long id) {

    Optional<Aluno> aluno = alunoService.findById(
      requireNonNull(id, "O id é obrigatório"));

    if (aluno.isPresent()) {
      return ResponseEntity.ok(aluno.get()); // 200 {"nome": "Marcio"}
      // return ResponseEntity.ok().body(aluno.get());
    } else {
      // return ResponseEntity.noContent().build(); // 204
      // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      // return ResponseEntity.status(404).build();
      return ResponseEntity.notFound().build();
    }
  }
}
