package Pagamento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Pagamento {
    void pagar(double valor);

    default String recibo(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo!");
        String meio = getClass().getSimpleName();
        double taxa = taxaAplicada();
        if (taxa < 0 || taxa > 1) throw new IllegalArgumentException("Taxa deve estar entre 0 e 1");

        double total = valor + valor * taxa;
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return String.format(
                "+++ RECIBO +++\n" +
                        "Meio: %s\n" +
                        "Data: %s\n" +
                        "Valor: R$ %.2f\n" +
                        "Taxa: %.2f%%\n" +
                        "Total: R$ %.2f\n",
                meio, data, valor, taxa * 100, total
        );
    }

    default double taxaAplicada() {
        return 0.0;
    }
}
