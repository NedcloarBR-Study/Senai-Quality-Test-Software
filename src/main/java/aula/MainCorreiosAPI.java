package aula;

import java.util.Scanner;

public class MainCorreiosAPI {

	public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o seu CEP: ");
    String cep = scanner.nextLine();
		CorreiosAPI correiosAPI = new CorreiosAPI();
		Endereco end = correiosAPI.buscaCep(cep);
		System.out.println(end.getLogradouro());
		System.out.println(end.getBairro());
    System.out.println(end.getUf());
	}

}