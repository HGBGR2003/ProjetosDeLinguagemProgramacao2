/**
 * Representa um Computador utilizado pelos alunos para desenvolvimento de código.
 * Controla a marca do equipamento e o estado atual de processamento de programas.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public class Computador {

    /**
     * Marca ou fabricante do computador (ex.: Dell, Lenovo, Apple).
     */
    private String marca;

    /**
     * Indica se o computador está executando ou processando código no momento.
     */
    private boolean processandoCodigo;

    /**
     * Construtor da classe Computador.
     * Inicializa a marca informada e define o estado de processamento como {@code false} por padrão.
     *
     * @param marca Marca ou modelo do computador.
     */
    public Computador(String marca) {
        this.marca = marca;
        this.processandoCodigo = false;
    }

    /**
     * Obtém a marca do computador.
     *
     * @return A marca do computador em formato de texto.
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Atualiza o estado de processamento de código do computador.
     *
     * @param status {@code true} se o computador estiver processando código, {@code false} caso contrário.
     */
    public void setProcessandoCodigo(boolean status) {
        this.processandoCodigo = status;
    }

    /**
     * Verifica se o computador está processando código no momento.
     *
     * @return {@code true} se estiver processando código, {@code false} caso contrário.
     */
    public boolean isProcessandoCodigo() {
        return this.processandoCodigo;
    }
}