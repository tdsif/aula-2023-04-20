package br.edu.ifrs.riogrande.tads.cobaia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {
 
  @JsonProperty(value = "codigo")
  private Integer id;
  
  @JsonProperty("e_mail")
  private String email;

  @JsonIgnore
  private String outra = "outra";

  public Usuario() {}

  public Usuario(Integer id, String email) {
    this.id = id;
    this.email = email;
  }

  public String getOutra() {
    return outra;
  }

  public void setOutra(String outra) {
    this.outra = outra;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  

}
