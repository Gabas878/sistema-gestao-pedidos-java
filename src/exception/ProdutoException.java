package exception;

public class ProdutoException extends RuntimeException {

    public static void ProdutoDuplicadoException() throws RuntimeException {
        throw new RuntimeException("Ocorreu um erro: Produto Já Existente");
    }

    public static void ProdutoEstoqueException() throws RuntimeException {
        throw new RuntimeException("Ocorreu um Erro: Referente ao estoque do produto");
    }

    public static void StatusException() throws RuntimeException {
        throw new RuntimeException("Ocorreu um Erro: Referente ao Status do Pedido");
    }

    public static void ProdutoQuantidadeException() throws RuntimeException {
        throw new RuntimeException("Ocorreu um Erro: Referente a Quantidade do Pedido");
    }
}
