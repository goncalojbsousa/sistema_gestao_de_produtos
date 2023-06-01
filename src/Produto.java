import java.util.*;
public class Produto {
    private String nome;
    private String descricao;
    private String categoria;
    private double preco;
    private int quantidadeStock;


    public Produto(String nome, String descricao, String categoria, double preco, int quantidadeStock) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeStock = quantidadeStock;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeStock() {
        return quantidadeStock;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeStock(int quantidadeStock) {
        this.quantidadeStock = quantidadeStock;
    }

}