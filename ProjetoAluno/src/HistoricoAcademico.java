/**
 * Representa o histórico acadêmico de um estudante, controlando métricas
 * de desempenho como o Índice de Rendimento Acadêmico (IRA).
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public class HistoricoAcademico {

    /**
     * Índice de Rendimento Acadêmico (IRA) do estudante (varia tipicamente de 0.0 a 10.0).
     */
    private double ira;

    /**
     * Construtor padrão da classe HistoricoAcademico.
     * Inicializa o histórico com o IRA máximo inicial de 10.0.
     */
    public HistoricoAcademico() {
        this.ira = 10.0;
    }

    /**
     * Obtém o valor atual do Índice de Rendimento Acadêmico (IRA).
     *
     * @return O valor do IRA.
     */
    public double getIra() {
        return this.ira;
    }

    /**
     * Define ou atualiza o valor do Índice de Rendimento Acadêmico (IRA).
     *
     * @param ira Novo valor do IRA a ser registrado.
     */
    public void setIra(double ira) {
        this.ira = ira;
    }
}