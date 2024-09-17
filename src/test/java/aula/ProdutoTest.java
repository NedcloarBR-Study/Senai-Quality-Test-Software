package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

  private ProdutoDB db;
  private ProdutoValidar validador;

  @BeforeEach
  public void setup() {
    this.db = new ProdutoDB();
    this.validador = new ProdutoValidar();
  }

  @Test
  public void testProduto() {
    Produto produto = new Produto(1, "Produto A", 100);
    Assertions.assertEquals(1, produto.getCOD_PRODUTO());
    Assertions.assertEquals("Produto A", produto.getNOME_PRODUTO());
    Assertions.assertEquals(100, produto.getPRECO_PRODUTO());

    produto.setCOD_PRODUTO(2);
    produto.setNOME_PRODUTO("Produto B");
    produto.setPRECO_PRODUTO(200);
    Assertions.assertEquals(2, produto.getCOD_PRODUTO());
    Assertions.assertEquals("Produto B", produto.getNOME_PRODUTO());
    Assertions.assertEquals(200, produto.getPRECO_PRODUTO());

    String expected = "Produto [COD_PRODUTO=2, NOME_PRODUTO=Produto B, PRECO_PRODUTO=200]";
    Assertions.assertEquals(expected, produto.toString());
  }

  @Test
  public void testValidarString() {
    Assertions.assertArrayEquals(new String[] { "1", "Produto A", "100" },
        this.validador.validarString("1;Produto A;100"));
    Assertions.assertArrayEquals(null, this.validador.validarString("1;Produto A"));
  }

  @Test
  public void testValidarId() {
    Assertions.assertTrue(this.validador.validarId("123"));
    Assertions.assertFalse(this.validador.validarId("abc"));
  }

  @Test
  public void testValidarNome() {
    Assertions.assertTrue(this.validador.validarNome("Produto A"));
    Assertions.assertFalse(this.validador.validarNome(""));
  }

  @Test
  public void testValidarPreco() {
    Assertions.assertTrue(this.validador.validarPreco("123"));
    Assertions.assertFalse(this.validador.validarPreco("abc"));
  }

  @Test
  public void testAdicionarProduto() {
    Produto produto = new Produto(1, "Produto A", 100);

    Assertions.assertTrue(db.adicionarProduto(produto));
    Assertions.assertFalse(db.adicionarProduto(produto));
  }

  @Test
  public void testToStringProdutoDB() {
    Produto produto1 = new Produto(1, "Produto A", 100);
    Produto produto2 = new Produto(2, "Produto B", 200);

    this.db.adicionarProduto(produto1);
    this.db.adicionarProduto(produto2);

    String expected = "ProdutoDB [LISTA_PRODUTOS=[Produto [COD_PRODUTO=1, NOME_PRODUTO=Produto A, PRECO_PRODUTO=100], Produto [COD_PRODUTO=2, NOME_PRODUTO=Produto B, PRECO_PRODUTO=200]]]";
    Assertions.assertEquals(expected, this.db.toString());
  }
}
