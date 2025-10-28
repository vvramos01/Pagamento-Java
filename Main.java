package Pagamento;

public class Main {
    public static void main(String[] args) {
        Pagamento cartao = new PagamentoCartao(0.05); // 5% de taxa
        Pagamento pix = new PagamentoPix();

        System.out.println("--------------------------------");
        cartao.pagar(200.00);

        System.out.println("--------------------------------");
        pix.pagar(150.00);
    }
}
