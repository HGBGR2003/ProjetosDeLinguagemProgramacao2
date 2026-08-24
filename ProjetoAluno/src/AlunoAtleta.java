/**
 * Representa um Aluno com perfil de Atleta, que estende as funcionalidades
 * da classe {@link Aluno} e implementa a interface {@link RecebedorBolsa}.
 * Possui rotinas específicas de treinamento e recebimento de bolsa estágio.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Aluno
 * @see RecebedorBolsa
 */
public class AlunoAtleta extends Aluno implements RecebedorBolsa {
    /**
     * Indica se o atleta realizou o treino com sucesso na última sessão.
     */
    private boolean treinar;

    /**
     * Valor em reais (R$) da bolsa estágio recebida pelo aluno atleta.
     */
    private double bolsaEstagio;


    /**
     * Construtor da classe AlunoAtleta.
     * @param nome         Nome do aluno atleta.
     * @param dinheiro     Saldo financeiro inicial.
     * @param energia      Nível inicial de energia.
     * @param treinar      Estado inicial de treinamento.
     * @param bolsaEstagio Valor financeiro da bolsa estágio.
     */
    public AlunoAtleta(String nome, double dinheiro, int energia, boolean treinar, double bolsaEstagio) {
        super(nome, dinheiro, energia);
        this.treinar = treinar;
        this.bolsaEstagio = bolsaEstagio;
    }

    /**
     * Processa o pagamento da bolsa estágio, creditando o valor correspondente no saldo financeiro do aluno caso o valor seja válido.
     */
    @Override
    public void processarPagamentoBolsa() {
        linha();
        if (this.bolsaEstagio > 0) {
            this.setDinheiro(this.getDinheiro() + this.bolsaEstagio);
            System.out.println("O Pagamento da bolsa no valor de R$ " + this.bolsaEstagio);
            linha();
        } else {
            System.out.println("Valor da Bolsa Não Recebido, por isso não passou");
        }
        getStatus();
    }

    /**
     * Executa a rotina de estudo do atleta.
     * Consome 5 pontos de energia se houver energia suficiente, caso contrário zera a energia.
     */
    @Override
    public void estudar() {
        linha();
        if (this.getEnergia() > 5) {
            this.setEnergia(this.getEnergia() - 5);
            System.out.println(this.getNome() + " estudou!");
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER!");
        }
        getStatus();
    }

    /**
     * Executa o ciclo de treinamento do atleta:
     * <ul>
     *   <li>Se a energia for maior que 25: consome 25 de energia, define treino como realizado e estuda.</li>
     *   <li>Se a energia estiver entre 6 e 25: não treina, mas ainda estuda.</li>
     *   <li>Se a energia for 5 ou menor: zera a energia e encerra a atividade.</li>
     * </ul>
     */

    public void treinamento() {
        if (this.getEnergia() > 25) { // Ele pra treinar usa 25 de energia.
            this.setEnergia(this.getEnergia() - 25);
            this.treinar = true;
            System.out.println(this.getNome() + " treinou!");
            estudar();
        } else if (this.getEnergia() > 5) { //Estudando ele tira o 5.
            this.treinar = false;
            System.out.println(this.getNome() + " não tinha energia para treinar, mas ainda estudou!");
            estudar();
        } else {
            this.setEnergia(0);
            this.treinar = false;
            System.out.println("GAME OVER!");
        }
    }
}
