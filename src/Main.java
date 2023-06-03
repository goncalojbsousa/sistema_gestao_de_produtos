import java.util.*;
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Criar uma conta");
            System.out.println("2. Efetuar login");
            System.out.println("0. Sair");
            System.out.println("\nOpção:");

            int opcao = scanner.nextInt();
            // nao tem necessidade de limpar o buffer
            //scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    sistema.criarConta();
                    break;
                case 2:
                    if (sistema.login()) {
                        while(true) {
                            System.out.println("\nSelecione uma opção:");
                            System.out.println("1 - Editar conta");
                            System.out.println("2 - Adiciona produto");
                            System.out.println("3 - Editar produto");
                            System.out.println("5 - Remover produto");
                            System.out.println("6 - Perquisar produto");
                            int opcaoLogado = scanner.nextInt();
                            // nao tem necessidade de limpar o buffer
                            //scanner.nextLine(); // Limpar o buffer do scanner
                            switch(opcaoLogado) {
                                case 1:
                                    sistema.editarConta();
                                    break;
                                case 2:
                                    sistema.adicionarProduto(scanner);
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
                                    sistema.pesquisar(scanner);
                                    break;
                                case 7:
                                    //volta para o inicio
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                            if(opcaoLogado == 7) break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("A encerrar...");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}