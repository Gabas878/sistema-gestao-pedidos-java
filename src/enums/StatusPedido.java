package enums;

public enum StatusPedido {
    PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE, CANCELADO;

    public boolean podeAlterarStatus(StatusPedido novoStatus) {
        switch (this) {
            case PENDENTE:
                return novoStatus == PROCESSANDO || novoStatus == CANCELADO;

            case PROCESSANDO:
                return novoStatus == CANCELADO || novoStatus == ENVIADO;

            case ENVIADO:
                return novoStatus == ENTREGUE;

            case CANCELADO:
            case ENTREGUE:
                return false;

            default:
                return false;
        }
    }
}
