package br.edu.ifgoiano.encontros;

import java.util.ArrayList;

/**
 * Classe principal de simulação e execução da Arena de Robôs de Combate.
 * Demonstra a aplicação prática dos conceitos de:
 * <ul>
 *   <li><b>Polimorfismo:</b> Gerenciamento de diferentes especializações de {@link RoboCombate} em uma mesma coleção.</li>
 *   <li><b>Sobrescrita de Métodos:</b> Comportamentos de ataque e defesa específicos para {@link RoboLaser} e {@link RoboTanque}.</li>
 *   <li><b>Interfaces:</b> Implementação e uso de {@link MecanismoDefesa}.</li>
 * </ul>
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see RoboCombate
 * @see RoboLaser
 * @see RoboTanque
 * @see MecanismoDefesa
 */
public class ArenaMain {

    /**
     * Construtor padrão da classe ArenaMain.
     */
    public ArenaMain() {
    }

    /**
     * Ponto de entrada da simulação de combate.
     * Cria os robôs participantes, executa os turnos de ataque e contra-ataque,
     * e exibe o relatório com a vida restante de cada combatente ao final.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        ArrayList<RoboCombate> robos = new ArrayList<>();

        robos.add(new RoboLaser("Destruidor-Laser", 100.0, 50.0, 100.0));
        robos.add(new RoboTanque("Blindado-Tanque", 120.0, 200.0, true));

        for (int turno = 1; turno <= 2; turno++) {
            System.out.println("\n--- TURNO " + turno + " ---");
            RoboCombate robo1 = robos.get(0);
            RoboCombate robo2 = robos.get(1);

            // Robô 1 ataca o Robô 2
            System.out.println("-> " + robo1.getNome() + " atacando:");
            robo1.atacar(robo2);

            // Robô 2 revida no Robô 1
            System.out.println("\n-> " + robo2.getNome() + " contra-atacando:");
            robo2.atacar(robo1);
        }

        System.out.println("\n--- RESULTADO FINAL ---");
        for (RoboCombate r : robos) {
            System.out.println(r.getNome() + " terminou com vida: " + r.getVida());
        }
    }
}