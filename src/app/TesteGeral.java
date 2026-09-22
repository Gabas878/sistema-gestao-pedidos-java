package app;

import service.ProdutoService;
import enums.StatusPedido;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import java.util.List;

public class TesteGeral {

    static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService();

        Produto notebook = new Produto(1, "Notebook", "Eletronico", 3900.89, 10);
        Produto celular = new Produto(2, "Celular", "Eletronico", 1900.89, 10);
        Produto caderno = new Produto(3, "Caderno", "Escolar", 30, 100);
        Produto caneta = new Produto(4, "Caneta", "Escolar", 2, 0);
        Produto nerf = new Produto(5, "Nerf", "Brinquedo", 200, 30);
        Produto bola = new Produto(6, "Bola", "Brinquedo", 50, 10);


        produtoService.cadastrarProduto(notebook);
        produtoService.cadastrarProduto(celular);
        produtoService.cadastrarProduto(caderno);
        produtoService.cadastrarProduto(nerf);
        produtoService.cadastrarProduto(bola);

        try {
            produtoService.cadastrarProduto(caneta);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            produtoService.cadastrarProduto(bola);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        Produto encontrado = produtoService.buscarProduto.apply("Notebook");
        System.out.println("Buscando produto por nome:");
        System.out.println(encontrado);

        System.out.println("----------------");
        System.out.println("Lista de Produtos: ");
        produtoService.listarTodosProdutos();

        System.out.println("--------------");
        System.out.println("Buscando por categoria: ");
        List<Produto> encontrado2 = produtoService.buscarPorCategoria.apply("Eletronico");
        System.out.println(encontrado2);


        Cliente cliente = new Cliente(
                "Gabriel",
                "12345678900",
                "gabriel@email.com"
        );

        System.out.println("--------------");
        System.out.println("Cliente: ");
        System.out.println(cliente.getNome());

        ItemPedido itemNotebook = new ItemPedido(notebook, 3);
        ItemPedido itemNotebook2 = new ItemPedido(notebook, 3);
        ItemPedido itemBola = new ItemPedido(bola, 10);
        ItemPedido itemNerf = new ItemPedido(nerf, 30);

        Pedido pedido = new Pedido(
                cliente,
                StatusPedido.PENDENTE
        );
        System.out.println("--------------");
        System.out.println("Status Inicial:");
        System.out.println(pedido.getStatus());

        pedido.adicionarItem(itemBola);
        pedido.adicionarItem(itemNerf);
        pedido.adicionarItem(itemNotebook);
        pedido.adicionarItem(itemNotebook2);




        System.out.println("--------------");
        System.out.println("Itens do Pedido:");

       pedido.itensDoPedido();

        System.out.println("--------------");
        System.out.printf(
                "Total do Pedido: R$ %.2f%n",
                pedido.valorTotalPedido()
        );

        System.out.println("--------------");
        pedido.alterarStatus(StatusPedido.PROCESSANDO);

        System.out.println("Novo Status:");
        System.out.println(pedido.getStatus());
        System.out.println("--------------");

        pedido.alterarStatus(StatusPedido.ENVIADO);
        System.out.println("Novo Status:");
        System.out.println(pedido.getStatus());
        System.out.println("--------------");

        pedido.alterarStatus(StatusPedido.ENTREGUE);
        System.out.println("Novo Status:");
        System.out.println(pedido.getStatus());
        System.out.println("--------------");


        System.out.println("Testando Status Invalido:");
        try {
            pedido.alterarStatus(StatusPedido.CANCELADO);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(notebook.getEstoque());
        System.out.println(bola.getEstoque());
        System.out.println(nerf.getEstoque());

        produtoService.listarTodosProdutos();
    }
}
