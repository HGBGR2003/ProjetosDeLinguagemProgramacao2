package br.edu.ifgoiano.encontros;

/**
 * Interface que define o contrato para mecanismos de defesa em entidades de combate.
 * Especifica os métodos necessários para ativação e verificação do estado de escudos de proteção.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public interface MecanismoDefesa {

    /**
     * Ativa o escudo de proteção da entidade, reduzindo ou bloqueando danos recebidos.
     */
    void ativarEscudo();

    /**
     * Verifica se o escudo de proteção está atualmente ativado.
     *
     * @return {@code true} se o escudo estiver ativo, {@code false} caso contrário.
     */
    boolean isEscudoAtivo();
}