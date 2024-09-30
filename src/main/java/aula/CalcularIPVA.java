package aula;

public class CalcularIPVA {

  public static double calcularIPVA(Double ipva, Integer idade, Boolean descontoBomCondutor) {
    if (ipva == null || idade == null || descontoBomCondutor == null) {
      return 0.0;
    }

    if (idade >= 60 && descontoBomCondutor) {
      return ipva * 0.7;
    }

    if (idade >= 40 && idade <= 59 && descontoBomCondutor) {
      return ipva * 0.75;
    }

    if (descontoBomCondutor) {
      return ipva * 0.85;
    }

    return ipva;
  }
}
