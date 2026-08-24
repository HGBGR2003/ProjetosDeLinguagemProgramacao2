/**
 * Interface que define o contrato para entidades aptas a receber pagamentos de bolsa.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public interface RecebedorBolsa {
    /**
     * Processa a validação e o crédito do pagamento da bolsa.
     */
    void processarPagamentoBolsa();
}
