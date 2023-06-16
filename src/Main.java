import java.util.*;
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Criar uma conta");
            System.out.println("2. Efetuar login");
            System.out.println("3. Sair");
            System.out.println("\nOpção:");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    sistema.criarConta();
                    break;
                case 2:
                    if (sistema.login()) {
                        while(true) {
                            System.out.println("\n1 - Editar conta");
                            System.out.println("2 - Adiciona produto");
                            System.out.println("3 - Editar produto");
                            System.out.println("4 - Listar produto");
                            System.out.println("5 - Remover produto");
                            System.out.println("6 - Perquisar produto");
                            System.out.println("7 - Registrar ecomenda");
                            System.out.println("8 - Ver relatorios de vendas");
                            System.out.println("9 - Voltar");
                            System.out.println("\nSelecione uma opção:");
                            int opcaoLogado = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer do scanner
                            switch(opcaoLogado) {
                                case 1:
                                    sistema.editarConta();
                                    break;
                                case 2:
                                    sistema.adicionarProduto();
                                    break;
                                case 3:
                                    sistema.editarProduto();
                                    break;
                                case 4:
                                    sistema.ListarProdutos();
                                    break;
                                case 5:
                                    sistema.removerProduto();
                                    break;
                                case 6:
                                    sistema.pesquisar();
                                    break;
                                case 7:
                                    sistema.registrarEncomenda();
                                    break;
                                case 8:
                                    sistema.criarRelatorioVendas();
                                    break;
                                case 9:
                                    //volta para o inicio
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                            if(opcaoLogado == 9) break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("A encerrar...");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}