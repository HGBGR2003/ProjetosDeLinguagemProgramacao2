import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma República estudantil que pode acolher qualquer tipo de aluno
 * (Regular, Estagiário, Atleta, etc.).
 * Demonstra os conceitos de Polimorfismo e Agregação, onde a república gerencia
 * uma coleção de instâncias de {@link Aluno} que mantêm ciclos de vida independentes.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Aluno
 */
public class Republica {

    /**
     * Nome identificador da república estudantil.
     */
    private String nomeRepublica;

    /**
     * Lista contendo os moradores da república (relação de Agregação polimórfica com {@link Aluno}).
     */
    private List<Aluno> moradores;

    /**
     * Construtor da classe Republica.
     * Inicializa o nome da república e instancia a lista de moradores vazia.
     *
     * @param nome Nome da república estudantil.
     */
    public Republica(String nome) {
        this.nomeRepublica = nome;
        this.moradores = new ArrayList<>();
    }

    /**
     * Acolhe e adiciona um aluno (de qualquer tipo derivado de {@link Aluno})
     * à lista de moradores, evitando valores nulos ou duplicatas.
     *
     * @param aluno Objeto {@link Aluno} que passará a morar na república.
     */
    public void acolherAluno(Aluno aluno) {
        if (aluno != null && !moradores.contains(aluno)) {
            this.moradores.add(aluno);
            System.out.println(aluno.getNome() + " mudou-se para a República " + this.nomeRepublica);
        }
    }

    /**
     * Remove um aluno da lista de moradores da república e atualiza a listagem exibida no console.
     *
     * @param aluno Objeto {@link Aluno} a ser removido da moradia.
     */
    public void expulsarAluno(Aluno aluno) {
        if (aluno != null && moradores.contains(aluno)) {
            moradores.remove(aluno);
            System.out.println(aluno.getNome() + " foi expulso da República " + this.nomeRepublica);
        }
        exibirMoradores();
        linha();
    }

    /**
     * Exibe no console a lista atualizada com o nome de todos os alunos moradores.
     */
    public void exibirMoradores() {
        System.out.println("=== Moradores da República " + this.nomeRepublica + " ===");
        for (Aluno est : moradores) {
            System.out.println("- " + est.getNome());
        }
    }

    /**
     * Imprime uma linha divisória no console para padronização visual da saída.
     */
    public void linha() {
        System.out.println("--------------------------");
    }

    /**
     * Obtém o nome da república.
     *
     * @return O nome da república.
     */
    public String getNomeRepublica() {
        return nomeRepublica;
    }

    /**
     * Define ou altera o nome da república.
     *
     * @param nomeRepublica Novo nome para a república.
     */
    public void setNomeRepublica(String nomeRepublica) {
        this.nomeRepublica = nomeRepublica;
    }

    /**
     * Obtém a lista de alunos moradores da república.
     *
     * @return Lista contendo os objetos do tipo {@link Aluno}.
     */
    public List<Aluno> getMoradores() {
        return moradores;
    }
}