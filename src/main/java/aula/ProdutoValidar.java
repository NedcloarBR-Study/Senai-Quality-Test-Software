package aula;

public class ProdutoValidar {
  public String[] validarString(String input) {
    String[] dados = input.split(";");

    if (dados.length != 3) {
      return null;
    }

    return dados;
  }

  public boolean validarId(String id) {
    try {
      Float.parseFloat(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean validarNome(String nome) {
    if (nome.isEmpty()) {
      return false;
    }

    return true;
  }

  public boolean validarPreco(String preco) {
    try {
      Float.parseFloat(preco);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
