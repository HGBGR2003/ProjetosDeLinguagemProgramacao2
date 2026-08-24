package br.edu.ifgoiano.edu.alunos;

/**
 * Classe principal de execução para teste e simulação do sistema de medição e consumidores.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public class Main {

     /**
      * Construtor padrão da classe Main.
      */
     public Main() {
     }

     /**
      * Ponto de entrada do programa. Cria instâncias de {@link Medidor} e {@link Consumidor},
      * realizando testes de consumo, injeção e registros de tensão.
      *
      * @param args Argumentos da linha de comando (não utilizados).
      */
     public static void main(String[] args) {
          Medidor medidor = new Medidor("00:1A:2B:3C:4D:4E", "bifásico");

          medidor.registrarConsumo(10.5);
          // medidor.registrarConsumo(-3); // Irá dar erro, pois o consumo não pode ser negativo!

          medidor.setTensao(0, 220);
          medidor.setTensao(1, 210);
          // medidor.setTensao(2, 290); // Passou do limite que está entre 90V a 250V.

          medidor.registrarInjecao(3.2);

          Consumidor consumidor = new Consumidor("Henrique Gabriel Barbosa Guida Rodrigues", "6627595724", medidor);

          System.out.println("Consumidor: " + consumidor.getNome());
          System.out.println("Documento: " + consumidor.getDocumento());
          System.out.println("MAC: " + medidor.getEnderecoMac());
          System.out.println("Tipo Medidor: " + medidor.getMedidor());
          System.out.println("Consumo: " + medidor.getValorConsumido() + " kWh");
          System.out.println("Injeção: " + medidor.getValorIngetado() + " kWh");
     }
}