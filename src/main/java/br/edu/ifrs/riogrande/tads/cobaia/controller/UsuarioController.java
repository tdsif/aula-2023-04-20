package br.edu.ifrs.riogrande.tads.cobaia.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.cobaia.model.Usuario;

@RestController
public class UsuarioController {
  
  @GetMapping("/api/v1/usuario")
  public Map<String, Object> getUsuario() {
  
    return Map.of(
      "nome", "Marcio",
      "sobrenome", "Torres");
  }

  @GetMapping("/api/v2/usuario")
  public Map<String, Object> getUsuario2() {

    return Map.of("usuario", Map.of(
        "nome", "Marcio",
        "sobrenome", "Torres"));
  }

  @GetMapping("/api/v3/usuario")
  public Usuario getUsuario3() {
    return new Usuario(123, "Victor");
  }

  // public static void main(String[] args) throws Exception {
  //   Usuario u = new Usuario();
  //   u.setEmail("teste@teste.com");
  //   u.setId(12321312);

  //   ObjectMapper mapper = new ObjectMapper();

  //   System.out.println(mapper.writeValueAsString(u));

  //   Usuario u2 = mapper.readValue("{\"id\":888, \"email\": \"m@m.co\"}", Usuario.class);

  //   System.out.println(u2.getEmail());
  // }
}
