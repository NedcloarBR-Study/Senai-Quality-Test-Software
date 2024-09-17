package aula;

import java.util.Scanner;

public class ProdutoMain {

  private static final String MENU = "\n=== Sistema de Gerenciamento de Produtos ===\n" +
      "1. Adicionar Produto\n" +
      "2. Ver Lista de Produtos\n" +
      "3. Sair\n" +
      "Digite a opção desejada:";

  private static final String ADICIONAR_PRODUTO_INSTRUCAO = "Digite as informações do produto no formato: codigo;nome;preço\n"
      +
      "Exemplo: 0;Smart TV;1250\n" +
      "Digite 'cancel' para voltar ao menu principal.";

  public static void main(String[] args) {
    ProdutoValidar validador = new ProdutoValidar();
    ProdutoDB db = new ProdutoDB();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println(MENU);

      String escolha = scanner.nextLine();

      switch (escolha) {
        case "1":
          // Adicionar produto
          while (true) {
            System.out.println(ADICIONAR_PRODUTO_INSTRUCAO);
            String input = scanner.nextLine();

            if (input.equals("cancel")) {
              break; // Volta ao menu principal
            }

            String[] dados = validador.validarString(input);

            if (dados == null) {
              System.out.println("Formato inválido. Tente novamente.");
              continue;
            }

            if (!validador.validarId(dados[0])) {
              System.out.println("Código inválido.");
              continue;
            }

            if (!validador.validarNome(dados[1])) {
              System.out.println("Nome inválido.");
              continue;
            }

            if (!validador.validarPreco(dados[2])) {
              System.out.println("Preço inválido. Deve ser um número.");
              continue;
            }

            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            int preco = Integer.parseInt(dados[2]);

            boolean adicionado = db.adicionarProduto(new Produto(id, nome, preco));
            if (!adicionado) {
              System.out.println("Ocorreu um erro ao adicionar o produto. Talvez o código inserido já exista.");
            } else {
              System.out.println("Produto adicionado com sucesso!");
            }
          }
          break;

        case "2":
          // Ver lista de produtos
          System.out.println("\nLista de Produtos:");
          System.out.println(db);
          break;

        case "3":
          // Sair
          System.out.println("Saindo do sistema. Até logo!");
          scanner.close();
          return;

        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }
}
