package service;

import exception.ProdutoException;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();


    public void cadastrarProduto(Produto produto) {
        if(buscarProduto.apply(produto.getNome()) != null) {
                ProdutoException.ProdutoDuplicadoException();

        }else if (produto.estoque <= 0) {
                ProdutoException.ProdutoEstoqueException();
        }else {
            produtos.add(produto);
        }
    }

    public Function<String, Produto> buscarProduto = p -> {
       return produtos.stream()
               .filter(produto -> produto.getNome().equalsIgnoreCase(p))
               .findFirst()
               .orElse(null);
   };

    public void listarTodosProdutos() {
        produtos.forEach(System.out::println);
    }

    public Function<String, List<Produto>> buscarPorCategoria = p -> {
        return produtos.stream()
                .filter(produto -> produto.getCategoria().equalsIgnoreCase(p))
                .toList();
    };

    public void produtosSemEstoque() {
        produtos.stream()
                .filter(produto -> produto.getEstoque() == 0)
                .forEach(System.out::println);
    }
}
