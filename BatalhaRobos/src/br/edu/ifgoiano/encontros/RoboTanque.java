package br.edu.ifgoiano.encontros;

/**
 * Representa um robô de combate com blindagem reforçada e capacidade defensiva.
 * Estende a classe {@link RoboCombate} e implementa a interface {@link MecanismoDefesa},
 * permitindo ativar um escudo de energia que reduz em 50% todo o dano recebido.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see RoboCombate
 * @see MecanismoDefesa
 */
public class RoboTanque extends RoboCombate implements MecanismoDefesa {

    /**
     * Indica se o escudo de defesa está atualmente ligado/ativo.
     */
    private boolean escudoLigado;

    /**
     * Construtor da classe RoboTanque.
     *
     * @param nome         Nome do robô tanque.
     * @param vida         Pontos de vida iniciais.
     * @param pesoKg       Peso do robô em quilogramas (usado para calcular o impacto físico).
     * @param escudoLigado Estado inicial do escudo de proteção.
     */
    public RoboTanque(String nome, double vida, double pesoKg, boolean escudoLigado) {
        super(nome, vida, pesoKg);
        this.escudoLigado = escudoLigado;
    }

    /**
     * Ativa o escudo de proteção do robô tanque.
     */
    @Override
    public void ativarEscudo() {
        this.escudoLigado = true;
        System.out.println(getNome() + " ativou o escudo de defesa!");
    }

    /**
     * Verifica se o escudo de proteção está ativo no momento.
     *
     * @return {@code true} se o escudo estiver ligado, {@code false} caso contrário.
     */
    @Override
    public boolean isEscudoAtivo() {
        return this.escudoLigado;
    }

    /**
     * Sobrescreve a definição de vida para interceptar danos recebidos.
     * Caso o escudo esteja ativo e o robô sofra dano, o dano é reduzido em 50%.
     *
     * @param vida Novos pontos de vida após o cálculo do dano.
     */
    @Override
    public void setVida(double vida) {
        if (vida > 0) {
            // Se a nova vida for menor que a vida atual, sofreu dano
            double danoOriginal = getVida() - vida;
            if (isEscudoAtivo() && danoOriginal > 0) {
                double danoReduzido = danoOriginal * 0.5;
                System.out.println(getNome() + " usou o escudo! Dano reduzido de " + danoOriginal + " para " + danoReduzido);
                vida = getVida() - danoReduzido;
            }
        }
        super.setVida(vida);
    }

    /**
     * Executa um ataque de impacto físico baseado no peso do robô tanque.
     * O dano é equivalente a 10% do peso em kg, com valor mínimo garantido de 10 de dano.
     *
     * @param adversario Instância do {@link RoboCombate} que sofrerá o impacto físico.
     */
    @Override
    public void atacar(RoboCombate adversario) {
        if (getVida() <= 0) {
            System.out.println(getNome() + " está destruído e não pode atacar!");
            return;
        }

        double danoImpactoFisico = getPesoKg() * 0.1;
        if (danoImpactoFisico < 10) {
            danoImpactoFisico = 10; // Impacto mínimo
        }

        System.out.println(getNome() + " avança com impacto físico em " + adversario.getNome() + "!");

        double vidaNovaAdversario = adversario.getVida() - danoImpactoFisico;
        adversario.setVida(vidaNovaAdversario);
        System.out.println(adversario.getNome() + " vida atual: " + adversario.getVida());
    }

    /**
     * Verifica se o escudo está ligado.
     *
     * @return {@code true} se estiver ligado, {@code false} caso contrário.
     */
    public boolean isEscudoLigado() {
        return escudoLigado;
    }

    /**
     * Define ou altera o estado do escudo de proteção.
     *
     * @param escudoLigado Novo estado do escudo.
     */
    public void setEscudoLigado(boolean escudoLigado) {
        this.escudoLigado = escudoLigado;
    }
}