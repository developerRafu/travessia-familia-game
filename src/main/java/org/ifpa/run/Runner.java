package org.ifpa.run;

import org.ifpa.models.Pessoa;
import org.ifpa.models.enums.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Runner {
  private final List<Pessoa> ladoEsquerdo;
  private final List<Pessoa> ladoDireito;

  public Runner() {
    ladoDireito = new ArrayList<>();
    ladoEsquerdo = new ArrayList<>();
    init();
  }

  private void init() {
    Pessoa mae = new Pessoa();
    mae.setPeso(100D);
    mae.setTipo(Tipo.MAE);

    Pessoa pai = new Pessoa();
    pai.setPeso(100D);
    pai.setTipo(Tipo.PAI);

    Pessoa filho = new Pessoa();
    filho.setPeso(50D);
    filho.setTipo(Tipo.FILHO);

    Pessoa filha = new Pessoa();
    filha.setPeso(50D);
    filha.setTipo(Tipo.FILHA);

    ladoDireito.addAll(List.of(mae, pai, filho, filha));
  }

  public void run() {
    log("Pessoas no lado direito: " + ladoDireito.stream().map(pessoa -> pessoa.getTipo().name()).collect(Collectors.joining(", ")));
    while (ladoDireito.stream().anyMatch(Predicate.not(Pessoa::isRemoved))) {
      List<Pessoa> jogada = new ArrayList<>();
      for (Pessoa pessoa : ladoDireito) {
        if (!pessoa.isRemoved() && jogada.stream().mapToDouble(Pessoa::getPeso).sum() < 100D) {
          pessoa.setRemoved(Boolean.TRUE);
          jogada.add(pessoa);
        }
      }
      log("Esta levando " + jogada.stream().map(p -> p.getTipo().name()).collect(Collectors.joining(", ")) + ". Total: " + jogada.stream().mapToDouble(Pessoa::getPeso).sum() + "Kg");
      ladoEsquerdo.addAll(jogada);
      jogada.clear();
    }
  }

  private void log(String txt) {
    System.out.println(txt);

  }
}
