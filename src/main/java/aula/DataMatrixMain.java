package aula;

import java.util.Scanner;

public class DataMatrixMain {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o código: ");
    String code = scanner.nextLine();

    DataMatrix dataMatrix = new DataMatrix(code);
    System.out.println(dataMatrix);

    scanner.close();
  }

}
