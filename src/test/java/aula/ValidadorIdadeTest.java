package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorIdadeTest {
  @Test
  public void testMaiorDeIdade() {
    // arrange
    ValidadorIdade validador = new ValidadorIdade();
    int idade = 18;
    boolean esperado = true;

    // ack
    boolean resultado = validador.eMaiorIdade(idade);

    // assert
    Assertions.assertEquals(esperado, resultado);
  }

  @Test
  public void testMaiorDeIdadeFalha() {
    // arrange
    ValidadorIdade validador = new ValidadorIdade();
    int idade = 17;
    boolean esperado = false;

    // ack
    boolean resultado = validador.eMaiorIdade(idade);

    // assert
    Assertions.assertEquals(esperado, resultado);
  }


  
}
