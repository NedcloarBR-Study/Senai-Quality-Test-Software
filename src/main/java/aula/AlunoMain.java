package aula;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade do aluno: ");
                int idade = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o mês de nascimento do aluno: ");
                int mesNascimento = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o ano de nascimento do aluno: ");
                int anoNascimento = Integer.parseInt(scanner.nextLine());

                Aluno aluno = new Aluno(nome, idade, mesNascimento, anoNascimento);
                alunos.add(aluno);

                System.out.println("Aluno cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
            }

            System.out.print("Deseja cadastrar outro aluno? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        System.out.println("\nLISTAGEM DE ALUNOS");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        scanner.close();
    }
}
