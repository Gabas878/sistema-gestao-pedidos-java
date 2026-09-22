package model;

import enums.StatusPedido;
import exception.ProdutoException;

import java.util.ArrayList;
import java.util.List;

public class Pedido {


    public Cliente getCliente() {
        return cliente;
    }


    public StatusPedido getStatus() {
        return status;
    }

    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status;


    public StatusPedido alterarStatus(StatusPedido novoStatus) {
        if (!this.status.podeAlterarStatus(novoStatus)) {
            ProdutoException.StatusException();
        }
        this.status = novoStatus;
        return status;
    }

    public Pedido(Cliente cliente, StatusPedido status) {
        this.cliente = cliente;
        this.status = status;

    }


    public int quantidadeNoPedido(ItemPedido item) {
       return itens.stream().filter(p -> p.getProduto().equals(item.getProduto()))
                .findFirst()
               .map(ItemPedido::getQuantidade)
               .orElse(0);
    }

    public boolean quantidadeInvalida(ItemPedido item) {
        int quantidadeNoPedido = quantidadeNoPedido(item);
        boolean quantidadeInvalida = item.getQuantidade() + quantidadeNoPedido < 1;
        return quantidadeInvalida;
    }

    public boolean estoqueProblema(ItemPedido item) {
        int quantidadeNoPedido = quantidadeNoPedido(item);
        boolean foraDeEstoque = item.getQuantidade() + quantidadeNoPedido > item.getProduto().getEstoque();
        return foraDeEstoque;
    }


    public void adicionarItem(ItemPedido item) {
            int estoqueAtual = item.getProduto().getEstoque();
        if(quantidadeInvalida(item)) {
            ProdutoException.ProdutoQuantidadeException();
        }else if (estoqueProblema(item)) {
            ProdutoException.ProdutoEstoqueException();
        }else if(itens.stream().anyMatch(p -> p.getProduto().equals(item.getProduto()))){
            itens.stream().filter(p -> p.getProduto().equals(item.getProduto()))
                    .findFirst()
                    .ifPresent(p -> p.adicionarQuantidade(item.getQuantidade()));
            item.getProduto().setEstoque(estoqueAtual - item.getQuantidade());
        }else {
            itens.add(item);
            item.getProduto().setEstoque(estoqueAtual - item.getQuantidade());}
    }

    public double valorTotalPedido() {
       return itens.stream()
                .mapToDouble(p -> p.getProduto().getPreco() * p.getQuantidade())
                .sum();
    }

    public void itensDoPedido() {
        itens.forEach(item -> {
            System.out.println(
                    item.getProduto().getNome()
                            + " | Quantidade: "
                            + item.getQuantidade()
                            + " | Preço: R$ "
                            + item.getProduto().getPreco()
            );
        });
    }

}
