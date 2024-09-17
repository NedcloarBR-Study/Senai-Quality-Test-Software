package aula;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDB {
  List<Produto> LISTA_PRODUTOS;

  public ProdutoDB() {
    this.LISTA_PRODUTOS = new ArrayList<Produto>();
  }

  public boolean adicionarProduto(Produto produto) {
    for (Produto p : LISTA_PRODUTOS) {
      if (p.getCOD_PRODUTO() == produto.getCOD_PRODUTO()) {
        return false;
      }
    }
    return this.LISTA_PRODUTOS.add(produto);
  }

  @Override
  public String toString() {
    if (this.LISTA_PRODUTOS.isEmpty()) {
      return "ProdutoDB [LISTA_PRODUTOS=vazio]";
    }
    return "ProdutoDB [LISTA_PRODUTOS=" + LISTA_PRODUTOS + "]";
  }

}
