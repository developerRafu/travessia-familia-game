package org.ifpa.models;

import org.ifpa.models.enums.Tipo;

public class Pessoa {
  private Double peso;
  private Tipo tipo;
  private boolean removed;

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public boolean isRemoved() {
    return removed;
  }

  public void setRemoved(boolean removed) {
    this.removed = removed;
  }
}
