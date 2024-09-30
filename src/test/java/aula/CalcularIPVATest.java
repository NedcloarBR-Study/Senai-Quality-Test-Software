package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcularIPVATest {

  @Test
  public void TESTE1() {
    // Arrange
    double ipva = 1000;
    int idade = 60;
    boolean descontoBomCondutor = true;

    // Act
    double resultado = CalcularIPVA.calcularIPVA(ipva, idade, descontoBomCondutor);

    // Assert
    Assertions.assertEquals(700, resultado, 0.01);
  }

  @Test
  public void TESTE2() {
    // Arrange
    double ipva = 1000;
    int idade = 45;
    boolean descontoBomCondutor = true;

    // Act
    double resultado = CalcularIPVA.calcularIPVA(ipva, idade, descontoBomCondutor);

    // Assert
    Assertions.assertEquals(750, resultado, 0.01);
  }

  @Test
  public void TESTE3() {
    // Arrange
    double ipva = 1000;
    int idade = 39;
    boolean descontoBomCondutor = true;

    // Act
    double resultado = CalcularIPVA.calcularIPVA(ipva, idade, descontoBomCondutor);

    // Assert
    Assertions.assertEquals(850, resultado, 0.01);
  }

  @Test
  public void TESTE4() {
    // Arrange
    double ipva = 1000;
    int idade = 60;
    boolean descontoBomCondutor = false;

    // Act
    double resultado = CalcularIPVA.calcularIPVA(ipva, idade, descontoBomCondutor);

    // Assert
    Assertions.assertEquals(1000, resultado, 0.01);
  }

  @Test
  public void TESTE5() {
    // Arrange
    Double ipva = null;
    Integer idade = null;
    Boolean descontoBomCondutor = null;

    // Act
    double resultado = CalcularIPVA.calcularIPVA(ipva, idade, descontoBomCondutor);

    // Assert
    Assertions.assertEquals(0, resultado, 0.01);
  }
}