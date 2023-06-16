import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
public class Encomenda {
    private int idProduto;
    private int quantidade;
    private String nomeProduto;
    private double preco;
    private LocalDate data;

    //construtor
    public Encomenda(int idProduto, int quantidade, String nomeProduto, double preco, LocalDate data){
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.data = data;
    }

    //gets e sets
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
