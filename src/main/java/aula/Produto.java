package aula;

public class Produto {
  private int COD_PRODUTO;
  private String NOME_PRODUTO;
  private int PRECO_PRODUTO;

  public Produto(int COD_PRODUTO, String NOME_PRODUTO, int PRECO_PRODUTO) {
    this.setCOD_PRODUTO(COD_PRODUTO);
    this.setNOME_PRODUTO(NOME_PRODUTO);
    this.setPRECO_PRODUTO(PRECO_PRODUTO);
  }

  public int getCOD_PRODUTO() {
    return COD_PRODUTO;
  }

  public void setCOD_PRODUTO(int COD_PRODUTO) {
    this.COD_PRODUTO = COD_PRODUTO;
  }

  public String getNOME_PRODUTO() {
    return NOME_PRODUTO;
  }

  public void setNOME_PRODUTO(String NOME_PRODUTO) {
    this.NOME_PRODUTO = NOME_PRODUTO;
  }

  public int getPRECO_PRODUTO() {
    return PRECO_PRODUTO;
  }

  public void setPRECO_PRODUTO(int PRECO_PRODUTO) {
    this.PRECO_PRODUTO = PRECO_PRODUTO;
  }

  @Override
  public String toString() {
    return "Produto [COD_PRODUTO=" + this.getCOD_PRODUTO() + ", NOME_PRODUTO=" + this.getNOME_PRODUTO()
        + ", PRECO_PRODUTO=" + this.getPRECO_PRODUTO() + "]";
  }

}