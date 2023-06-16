import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class Sistema {
    private Map<String, Utilizador> contas;
    private String userLogado;
    List<Produto> produtosCorrespondentes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private List<Produto> produtos;
    private List<Encomenda> encomendas;

    public Sistema() { //construtor
        contas = new HashMap<>();
        this.produtos = new ArrayList<>();
        this.encomendas = new ArrayList<>();
    }

    //metodo para criar uma conta
    public void criarConta() {
        //pede os dados para criar conta
        System.out.println("Criar uma nova conta:");
        System.out.println("Nome de usuário:");
        String usuario = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Informações de contato:");
        String contacto = scanner.nextLine();

        //verificar se a conta existe
        if (contas.containsKey(usuario)) {
            System.out.println("O nome de usuario não está disponivel.");
        } else {
            System.out.println("Conta criada com sucesso!");
            Utilizador novaConta = new Utilizador(nome, usuario, senha, contacto);
            contas.put(usuario, novaConta);
        }
    }

    //metodo para iniciar sessão
    public boolean login() {
        //pede os dados de login
        System.out.println("Login:");
        System.out.println("Nome de usuário:");
        String utilizador = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner

        for (Utilizador conta : contas.values()) {
            //verifica se os dados de login estao corretos
            if (conta.getNomeUsuario().equals(utilizador) && conta.getSenha().equals(senha)) {
                userLogado = conta.getNomeUsuario();
                System.out.println("Login bem-sucedido!");
                return true;
            }
        }
        System.out.println("Nome de usuário ou senha incorretos.");
        return false;
    }

    public void editarConta() {
        //pede os novos dados para atualizar
        System.out.println("Introduza os novos dados:");
        System.out.println("Nome:");
        String novoNome = scanner.nextLine();
        System.out.println("Nome de usuário:");
        String novoUsuario = scanner.nextLine();
        System.out.println("Senha:");
        String novaSenha = scanner.nextLine();
        System.out.println("Informações de contato:");
        String novoContacto = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner

        for (Utilizador conta : contas.values()) {
            if (contas.containsKey(userLogado)) {
                conta.setNome(novoNome);
                conta.setNomeUsuario(novoUsuario);
                conta.setSenha(novaSenha);
                conta.setContacto(novoContacto);
                System.out.println("Dados alterados com sucesso!");
            } else {
                System.out.println("Nome de usuario incorreto.");
            }
        }
    }

    public void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Verificar se o produto já existe
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println("O produto já existe. Não é possível adicioná-lo novamente.");
                return;
            }
        }

        System.out.print("Descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Categoria do produto: ");
        String categoria = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();

        int id = 0;
        for (int i = 0; i < produtos.toArray().length; i++)
            if (produtos.toArray()[i] != null)
                id++;
        id++;
        Produto produto = new Produto(nome, descricao, categoria, preco, quantidade, id);
        produtos.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    public void ListarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Produtos Indisponíveis");
            System.out.println("================================================");
        } else {
            for (Produto p : produtos) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Descrição: " + p.getDescricao());
                System.out.println("Categoria: " + p.getCategoria());
                System.out.println("Preco: " + p.getPreco());
                System.out.println("Quantidade Stock: " + p.getQuantidadeStock());
                System.out.println("ID do Produto: " + p.getId());
                System.out.println("============================================");
            }
        }
    }

    public void pesquisar() {
        System.out.println("Digite o nome ou categoria do produto:");
        String termo = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner
        for (Produto produto : produtos) {
            if (produto.getNome().contains(termo) || produto.getCategoria().contains(termo)) {
                produtosCorrespondentes.add(produto);
            }
        }

        if (produtosCorrespondentes.isEmpty()) {
            System.out.println("Não foram encontrados produtos com o termo da pesquisa");
        } else {
            System.out.println("Produtos encontrados:");
            for (Produto p : produtosCorrespondentes) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Descrição: " + p.getDescricao());
                System.out.println("Categoria: " + p.getCategoria());
                System.out.println("Preco: " + p.getPreco());
                System.out.println("Quantidade Stock: " + p.getQuantidadeStock());
                System.out.println("============================================");
            }
        }
    }

    public void removerProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Produtos Indisponíveis");
            System.out.println("================================================");
        } else {
            ListarProdutos();
            System.out.print("Digite o nome do produto que deseja remover: ");
            String remProduto = scanner.nextLine();

            for (Produto p : produtos) {
                if (p.getNome().equalsIgnoreCase(remProduto)) {
                    produtos.remove(p);
                    System.out.println("Produto removido com sucesso!");
                    break;
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
        }
    }

    public void editarProduto() {

        if (produtos.isEmpty()) {
            System.out.println("Produtos Indisponíveis");
            System.out.println("================================================");
        } else {
            System.out.println("Produtos Disponíveis:\n");
            ListarProdutos();
            System.out.print("Digite o nome do produto que deseja Editar: ");
            String editProduto = scanner.nextLine();

            for (Produto p : produtos) {
                if (p.getNome().equalsIgnoreCase(editProduto)) {
                    System.out.println("Introduza os novos dados:");
                    System.out.println("\nNome: ");
                    String novoNome = scanner.nextLine();
                    p.setNome(novoNome);
                    System.out.println("Categoria: ");
                    String novaCategoria = scanner.nextLine();
                    p.setCategoria(novaCategoria);
                    System.out.println("Descrição: ");
                    String novaDescricao = scanner.nextLine();
                    p.setDescricao(novaDescricao);
                    System.out.println("Preço: ");
                    double novoPreco = scanner.nextDouble();
                    p.setPreco(novoPreco);
                    System.out.println("Quantidade em Stock: ");
                    int novoStock = scanner.nextInt();
                    p.setQuantidadeStock(novoStock);
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
        }
    }

    // este metodo registra uma encomenda
    public void registrarEncomenda() {

        ListarProdutos();

        String nomeProduto = "";
        double precoProduto = 0;

        System.out.print("Selecione o ID do produto: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Insira a quantidade que pretende: ");
        int qtd = scanner.nextInt();
        System.out.printf("Insira a data: ");
        //transforma a data de string para localDate com o formato indicado
        String dataString = scanner.next();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for (Produto p : produtos) {
            if (p.getId() == idProduto) {
                nomeProduto = String.valueOf(p.getNome());
                precoProduto = (p.getPreco() * qtd);
                p.setQuantidadeStock((p.getQuantidadeStock() - qtd));
            }
        }

        Encomenda encomenda = new Encomenda(idProduto, qtd, nomeProduto, precoProduto, data);
        encomendas.add(encomenda);

        System.out.println("Produto adicionado com sucesso!");
    }

    //criacao dos relatorios
    public void criarRelatorioVendas() {
        System.out.println("\nSelecione uma opção:");
        System.out.println("1. Vendas totais por período de tempo");
        System.out.println("2. Vendas por produto");
        System.out.println("3. Voltar");
        System.out.println("\nOpção:");

        int opcaoRelatorio = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcaoRelatorio) {
            // cria relatorio de vendas por periodo de tempo
            case 1:
                System.out.println("Informe o período de tempo:");
                //guarda as datas inicial e final e transforma ambas de string para localDate para poderem ser comparadas
                System.out.print("Data inicial (dd/mm/aaaa): ");
                String dataInicialStr = scanner.nextLine();
                LocalDate dataInicial = LocalDate.parse(dataInicialStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.print("Data final (dd/mm/aaaa): ");
                String dataFinalStr = scanner.nextLine();
                LocalDate dataFinal = LocalDate.parse(dataFinalStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                // Chama método para obter as vendas totais por período de tempo
                List<Encomenda> vendasPorPeriodo = obterVendasPorPeriodo(dataInicial, dataFinal);

                if (vendasPorPeriodo.isEmpty()) {
                    System.out.println("Nenhuma venda encontrada para o período informado.");
                } else {
                    System.out.println("Vendas totais por período de tempo:");
                    for (Encomenda encomenda : vendasPorPeriodo) {
                        System.out.println("ID do Produto: " + encomenda.getIdProduto());
                        System.out.println("Quantidade: " + encomenda.getQuantidade());
                        System.out.println("Preço: " + encomenda.getPreco());
                        System.out.println("Data: " + encomenda.getData());
                    }
                }
                break;

            //cria relatorio das vendas de um produto
            case 2:
                System.out.print("Insira o id do produto: ");
                int idProduto = scanner.nextInt();

                // Chama método para obter as vendas por produto
                List<Encomenda> vendasPorProduto = obterVendasPorProduto(idProduto);

                if (vendasPorProduto.isEmpty()) {
                    System.out.println("Nenhuma venda encontrada para o produto informado.");
                } else {
                    System.out.println("Vendas por produto:");
                    for (Encomenda encomenda : vendasPorProduto) {
                        System.out.println("ID do Produto: " + encomenda.getIdProduto());
                        System.out.println("Quantidade: " + encomenda.getQuantidade());
                        System.out.println("Preço: " + encomenda.getPreco());
                        System.out.println("Data: " + encomenda.getData());
                    }
                }
                break;

            case 3:
                // Voltar
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    //método para obter as vendas totais por período de tempo
    private List<Encomenda> obterVendasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        List<Encomenda> vendasPorPeriodo = new ArrayList<>();

        for (Encomenda encomenda : encomendas) {
            LocalDate dataEncomenda = encomenda.getData();
            // Verificar se a data da encomenda está dentro do período especificado
            if (dataEncomenda.compareTo(dataInicial) >= 0 && dataEncomenda.compareTo(dataFinal) <= 0) {
                vendasPorPeriodo.add(encomenda);
            }
        }

        return vendasPorPeriodo;
    }

    //método para obter as vendas por produto
    private List<Encomenda> obterVendasPorProduto(int idProduto) {
        List<Encomenda> vendasPorProduto = new ArrayList<>();

        for (Encomenda encomenda : encomendas) {
            int idProdutoEncomenda = encomenda.getIdProduto();
            // Verifica se o ID do produto da encomenda corresponde ao produto desejado
            if (idProdutoEncomenda == idProduto) {
                vendasPorProduto.add(encomenda);
            }
        }

        return vendasPorProduto;
    }
}