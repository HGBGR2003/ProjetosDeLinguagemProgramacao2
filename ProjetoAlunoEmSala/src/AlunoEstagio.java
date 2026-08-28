/**
 * Representa um Aluno que realiza estágio remunerado, estendendo a classe
 * {@link Aluno} e implementando a interface {@link RecebedorBolsa}.
 * Gerencia a rotina de trabalho, recebimento de bolsa estágio e rotina de estudos.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Aluno
 * @see RecebedorBolsa
 */
public class AlunoEstagio extends Aluno implements RecebedorBolsa {
    /**
     * Valor em reais (R$) da bolsa de estágio recebida pelo aluno.
     */
    private double bolsa;

    /**
     * Construtor da classe AlunoEstagio.
     *
     * @param nome     Nome do aluno estagiário.
     * @param dinheiro Saldo financeiro inicial.
     * @param energia  Nível inicial de energia.
     * @param bolsa    Valor da bolsa de estágio.
     */
    public AlunoEstagio(String nome, double dinheiro, int energia, double bolsa) {
        super(nome, dinheiro, energia);
        this.bolsa = bolsa;
        System.out.println("Bolsa estágio: R$ " + this.bolsa);
    }

    /**
     * Simula a jornada de trabalho do estagiário.
     * Consome 40 pontos de energia e dispara o processo de pagamento da bolsa.
     */
    public void trabalhar() {
        linha();
        if (this.getEnergia() > 40) {
            this.setEnergia(this.getEnergia() - 40);
            System.out.println(this.getNome() + " terminou o trabalho!");
            processarPagamentoBolsa();
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER!");
            getStatus();
        }
    }

    /**
     * Processa o pagamento da bolsa de estágio, adicionando o valor ao saldo do aluno caso a bolsa seja maior que zero.
     */
    @Override
    public void processarPagamentoBolsa() {
        linha();
        if (this.getBolsa() > 0) {
            this.setDinheiro(this.getDinheiro() + this.bolsa);

            System.out.println("O Pagamento da bolsa no valor de R$ " + this.bolsa);
        } else {
            System.out.println("Valor da Bolsa Não Recebido, por isso não passou");
        }
        getStatus();
    }

    /**
     * Executa a rotina de estudos do aluno estagiário.
     * Consome 15 pontos de energia se houver energia suficiente, caso contrário zera a energia.
     */
    @Override
    public void estudar() { //gasta 15 de energia
        linha();
        if (this.getEnergia() > 15) {
            this.setEnergia(this.getEnergia() - 15);
            System.out.println(this.getNome() + " estudou!");
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER!");
        }
        getStatus();
    }

    /**
     * Obtém o valor da bolsa de estágio.
     *
     * @return O valor da bolsa em reais.
     */
    public double getBolsa() {
        return bolsa;
    }

    /**
     * Define um novo valor para a bolsa de estágio.
     *
     * @param bolsa Novo valor da bolsa em reais.
     */
    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }


}
