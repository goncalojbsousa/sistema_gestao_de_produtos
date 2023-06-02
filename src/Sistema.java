import java.util.*;

public class Sistema {
    private Map<String, Utilizador> contas;
    private String userLogado;
    List<Produto> produtosCorrespondentes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private List<Produto> produtos;
    public Sistema(){
        contas = new HashMap<>();
        this.produtos = new ArrayList<>();
    }
    //metodo para criar uma conta
    public void criarConta(){
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
        if(contas.containsKey(usuario)){
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

        // nao tem necessidade de limpar o buffer
        //scanner.nextLine(); // Limpar o buffer do scanner

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
    public void editarConta(){
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
            if (contas.containsKey(userLogado)){
                conta.setNome(novoNome);
                conta.setNomeUsuario(novoUsuario);
                conta.setSenha(novaSenha);
                conta.setContacto(novoContacto);
                System.out.println("Dados alterados com sucesso!");
            } else{
                System.out.println("Nome de usuario incorreto.");
            }
        }
    }
    public void adicionarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        if(scanner.hasNextLine()) scanner.nextLine(); // Limpar o buffer do scanner (caso haja alguma coisa)
        String nome = scanner.nextLine();

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

        Produto produto = new Produto(nome, descricao, categoria, preco, quantidade);
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
                System.out.println("============================================");
            }
        }
    }
    public void pesquisar(Scanner scanner){
        System.out.println("Digite o nome ou categoria do produto:");
        if(scanner.hasNextLine()) scanner.nextLine(); // Limpar o buffer do scanner
        String termo = scanner.nextLine();
        for (Produto produto : produtos) {
            if(produto.getNome().contains(termo) || produto.getCategoria().contains(termo)){
                produtosCorrespondentes.add(produto);
            }
        }

        if (produtosCorrespondentes.isEmpty()){
            System.out.println("Não foram encontrados produtos com o termo da pesquisa");
        } else{
            System.out.println("Produtos encontrados:");
            for (Produto p : produtosCorrespondentes ) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Descrição: " + p.getDescricao());
                System.out.println("Categoria: " + p.getCategoria());
                System.out.println("Preco: " + p.getPreco());
                System.out.println("Quantidade Stock: " + p.getQuantidadeStock());
                System.out.println("============================================");
            }
            /* apos exibir a lista com os resultados, é necessario limpar para quando houver uma nova busca, os mesmos
            resultados nao aparecerem de novo
             */
            produtosCorrespondentes.clear();
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
    public void editarProduto(){

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
}