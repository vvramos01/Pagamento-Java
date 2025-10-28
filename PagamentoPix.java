package Pagamento;

public class PagamentoPix implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println(recibo(valor));
    }

    @Override
    public double taxaAplicada() {
        return 0.01;
    }
}
