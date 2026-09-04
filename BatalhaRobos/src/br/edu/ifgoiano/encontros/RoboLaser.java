package br.edu.ifgoiano.encontros;

/**
 * Representa um robô de combate especializado em ataques à distância utilizando laser.
 * Estende a classe abstrata {@link RoboCombate}, calculando o dano causado e o custo
 * de energia próprio com base na potência do laser em Watts.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see RoboCombate
 */
public class RoboLaser extends RoboCombate {

    /**
     * Potência do canhão de laser medida em Watts (W).
     */
    private double potencialLaserWatts;

    /**
     * Construtor da classe RoboLaser.
     * Inicializa os atributos herdados e a potência do laser, aplicando valor padrão de 10W caso o valor informado seja inválido.
     *
     * @param nome                Nome do robô.
     * @param vida                Pontos de vida iniciais.
     * @param pesoKg              Peso do robô em quilogramas.
     * @param potencialLaserWatts Potência do laser em Watts (deve ser maior que zero).
     */
    public RoboLaser(String nome, double vida, double pesoKg, double potencialLaserWatts) {
        super(nome, vida, pesoKg);
        if (potencialLaserWatts > 0) {
            this.potencialLaserWatts = potencialLaserWatts;
        } else {
            System.out.println("Potencia Padrão de 10");
            this.potencialLaserWatts = 10.0;
        }
    }

    /**
     * Executa o disparo do laser contra um robô adversário.
     * Consome uma parcela de vida do próprio robô como custo de energia (5% da potência)
     * e aplica dano proporcional (20% da potência) aos pontos de vida do adversário.
     *
     * @param adversario Instância do {@link RoboCombate} que sofrerá o disparo do laser.
     */
    @Override
    public void atacar(RoboCombate adversario) {
        if (getVida() <= 0) {
            System.out.println(getNome() + " está destruído e não pode atacar!");
            return;
        }

        // Custo de energia para disparar o laser
        double custoEnergia = this.potencialLaserWatts * 0.05;

        // Dano causado proporcional à potência do laser
        double dano = this.potencialLaserWatts * 0.2;

        System.out.println(getNome() + " dispara um laser potente em " + adversario.getNome() + "!");

        // Reduz a vida do próprio robô (custo do disparo)
        double vidaNova = getVida() - custoEnergia;
        setVida(vidaNova);
        System.out.println(getNome() + " consumiu " + custoEnergia + " de vida no disparo. Vida restante: " + getVida());

        // Aplicando dano ao robô adversário
        double vidaNovaAdversarioRobo = adversario.getVida() - dano;
        adversario.setVida(vidaNovaAdversarioRobo);
        System.out.println(adversario.getNome() + " sofreu " + dano + " de dano! Vida restante: " + adversario.getVida());
    }

    /**
     * Obtém a potência atual do laser em Watts.
     *
     * @return A potência em Watts.
     */
    public double getPotencialLaserWatts() {
        return potencialLaserWatts;
    }

    /**
     * Define ou altera a potência do laser, aceitando apenas valores positivos.
     *
     * @param potencialLaserWatts Nova potência em Watts.
     */
    public void setPotencialLaserWatts(double potencialLaserWatts) {
        if (potencialLaserWatts > 0) {
            this.potencialLaserWatts = potencialLaserWatts;
        }
    }
}