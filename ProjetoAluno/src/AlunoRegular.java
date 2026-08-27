/**
 * Representa um Aluno Regular de graduação que não possui estágio nem bolsa atlética.
 * Possui inicialização padrão de saldo (R$ 200,00) e energia (100).
 * Demonstra conceitos de Associação com {@link Computador} e Composição com {@link HistoricoAcademico}.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Aluno
 * @see Computador
 * @see HistoricoAcademico
 */
public class AlunoRegular extends Aluno {

    /**
     * Número de matrícula ou código de identificação do aluno regular.
     */
    private double matricula;

    /**
     * Objeto da classe Computador associado ao aluno (relação de Associação).
     * Pode ser {@code null} caso o aluno não possua computador no momento.
     */
    private Computador pc;

    /**
     * Objeto da classe HistoricoAcademico pertencente ao aluno (relação de Composição).
     * É instanciado no construtor junto com o ciclo de vida do aluno.
     */
    private HistoricoAcademico historico;

    /**
     * Construtor da classe AlunoRegular.
     * Inicializa o aluno com saldo padrão de R$ 200,00, 100 pontos de energia
     * e cria automaticamente o seu histórico acadêmico.
     *
     * @param nome      Nome do aluno regular.
     * @param matricula Número de matrícula do aluno.
     */
    public AlunoRegular(String nome, double matricula) {
        super(nome, 200, 100);
        this.matricula = matricula;
        this.historico = new HistoricoAcademico();
    }

    /**
     * Executa a rotina intensa de estudos do aluno regular.
     * Consome 30 pontos de energia se houver energia suficiente, caso contrário zera a energia.
     */
    @Override
    public void estudar() {
        linha();
        if (this.getEnergia() > 30) {
            this.setEnergia(this.getEnergia() - 30);
            System.out.println(this.getNome() + " estudou!");
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER");
        }
        getStatus();
    }

    /**
     * Associa (ou desassocia passando {@code null}) um computador ao aluno.
     *
     * @param pc Instância de {@link Computador} a ser associada ao aluno.
     */
    public void setComputador(Computador pc) {
        this.pc = pc;
    }

    /**
     * Simula a atividade de programar em Java.
     * Caso o aluno possua um computador associado, ativa o processamento de código;
     * caso contrário, exibe mensagem de perrengue por falta de equipamento.
     */
    public void programarJava() {
        if (this.pc != null) {
            this.pc.setProcessandoCodigo(true);
            System.out.println(this.getNome() + " está codando no seu " + this.pc.getMarca() + ".");
        } else {
            System.out.println("[PERRENGUE] " + this.getNome() + " quer programar, mas está sem computador!");
        }
        linha();
    }

    /**
     * Simula a consequência de tirar nota baixa, aplicando uma penalização de 1.5 pontos
     * no Índice de Rendimento Acadêmico (IRA) do seu histórico.
     */
    public void tirarNotaBaixa() {
        double iraAtual = this.historico.getIra();
        this.historico.setIra(iraAtual - 1.5);
        System.out.println("[DESESPERO] " + this.getNome() + " tirou nota baixa! IRA caiu para: " + this.historico.getIra());
        linha();
    }

    /**
     * Obtém o número de matrícula do aluno.
     *
     * @return O número de matrícula.
     */
    public double getMatricula() {
        return matricula;
    }

    /**
     * Define ou atualiza o número de matrícula do aluno.
     *
     * @param matricula Novo número de matrícula.
     */
    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtém o computador atualmente associado ao aluno.
     *
     * @return O objeto {@link Computador} associado, ou {@code null} se não houver.
     */
    public Computador getPc() {
        return this.pc;
    }

    /**
     * Obtém o histórico acadêmico exclusivo do aluno.
     *
     * @return O objeto {@link HistoricoAcademico} do aluno.
     */
    public HistoricoAcademico getHistorico() {
        return this.historico;
    }
}