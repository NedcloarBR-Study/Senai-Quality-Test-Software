package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class CorreiosAPITeste {

  private CorreiosAPI correiosAPI;
  private CorreiosAPIServico correiosAPIServico;

  @BeforeEach
  public void setUp() {
    correiosAPI = Mockito.mock(CorreiosAPI.class);
    correiosAPIServico = new CorreiosAPIServico(correiosAPI);
  }

  @Test
  public void testBuscarCepEncontrado() {
    // arrange
    String cep = "12345678";
    Endereco enderecoMock = new Endereco();
    enderecoMock.setLogradouro("Rua Exemplo");
    enderecoMock.setBairro("Bairro Exemplo");
    enderecoMock.setUf("UF Exemplo");

    Mockito.when(correiosAPI.buscaCep(cep)).thenReturn(enderecoMock);

    // act
    Endereco resultado = correiosAPIServico.buscar(cep);

    // assert
    Assertions.assertEquals("Rua Exemplo", resultado.getLogradouro());
    Assertions.assertEquals("Bairro Exemplo", resultado.getBairro());
    Assertions.assertEquals("UF Exemplo", resultado.getUf());
  }

  @Test
  public void testBuscarCepNaoEncontrado() {
    // arrange
    String cep = "00000000";
    Mockito.when(correiosAPI.buscaCep(cep)).thenReturn(null);

    // act
    Endereco resultado = correiosAPIServico.buscar(cep);

    // assert
    Assertions.assertEquals("LOGRADOURO NÃO ENCONTRADO", resultado.getLogradouro());
    Assertions.assertEquals("BAIRRO NAO ENCONTRADO", resultado.getBairro());
    Assertions.assertEquals("UF NÃO ENCONTRADO", resultado.getUf());
  }

  @Test
  public void testBuscarCepEncontradoIntegracao() {
    // arrange
    CorreiosAPIServico correiosAPIServicoReal = new CorreiosAPIServico();
    String cep = "91110000";

    // act
    Endereco resultado = correiosAPIServicoReal.buscar(cep);

    // assert
    Assertions.assertNotNull(resultado);
    Assertions.assertNotEquals("LOGRADOURO NÃO ENCONTRADO", resultado.getLogradouro());
  }

  @Test
  public void testBuscarCepNaoEncontradoIntegracao() {
    // arrange
    CorreiosAPIServico correiosAPIServicoReal = new CorreiosAPIServico();
    String cep = "00000000";

    // act
    Endereco resultado = correiosAPIServicoReal.buscar(cep);

    // assert
    Assertions.assertEquals("LOGRADOURO NÃO ENCONTRADO", resultado.getLogradouro());
    Assertions.assertEquals("BAIRRO NAO ENCONTRADO", resultado.getBairro());
    Assertions.assertEquals("UF NÃO ENCONTRADO", resultado.getUf());
  }
}