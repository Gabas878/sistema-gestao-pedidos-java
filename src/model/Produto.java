package model;

public class Produto {

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getEstoque() {return estoque;}

    public void setEstoque(int estoque) {this.estoque = estoque++;}

    public String toString() {
        return "Nome: " + nome + "| Categoria: " + categoria + "| Preço: " + preco + "| Estoque: " + estoque;
    }

    public int id;
    public String nome;
    public String categoria;
    public double preco;
    public int estoque;

    public Produto(int id, String nome, String categoria, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
    }

}
