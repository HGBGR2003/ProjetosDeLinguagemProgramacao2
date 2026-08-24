/**
 * Representa um Aluno Regular de graduação que não possui estágio nem bolsa atlética.
 * Inicializa com valores pré-definidos de saldo (R$ 200,00) e energia (100).
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Aluno
 */
public class AlunoRegular extends Aluno {
    /**
     * Número de matrícula ou código de identificação do aluno regular.
     */
    private double matricula;

    /**
     * Construtor da classe AlunoRegular.
     * Inicializa o aluno com saldo padrão de R$ 200,00 e 100 pontos de energia.
     *
     * @param nome      Nome do aluno regular.
     * @param matricula Número de matrícula do aluno.
     */
    public AlunoRegular(String nome, double matricula) {
        super(nome, 200, 100);
        this.matricula = matricula;
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
     * Obtém o número de matrícula do aluno.
     * @return O número de matrícula.
     */
    public double getMatricula() {
        return matricula;
    }

    /**
     * Define ou atualiza o número de matrícula do aluno.
     * @param matricula Novo número de matrícula.
     */
    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }
}
