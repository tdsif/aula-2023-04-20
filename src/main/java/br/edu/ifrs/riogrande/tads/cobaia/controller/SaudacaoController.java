package br.edu.ifrs.riogrande.tads.cobaia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoController { // rotas?
  
  @RequestMapping(method = RequestMethod.GET, path = {"/oi", "/ola"})
  public String oi() { // retornar qualquer objeto
    return "Oi, tudo bem!!!!";
  }

  // http://localhost:8080/tchau/Jean
  @RequestMapping(method = RequestMethod.GET, path = "/tchau/{nome}")
  public String tchau(@PathVariable String nome) {
    return "Tchau " + nome;
  }

  @GetMapping("/boa-noite") // kebab-case (não se usa camelCase para URL)
  public String boaNoite() {
    return "Boa noite!";
  }


}
