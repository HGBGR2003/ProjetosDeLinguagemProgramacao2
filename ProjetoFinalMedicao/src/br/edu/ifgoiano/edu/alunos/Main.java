package br.edu.ifgoiano.edu.alunos;

/**
 * Classe principal de execução para teste e simulação do sistema de medição e consumidores.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public class Main {
     public static void main(String[] args) {
          System.out.println("=================================================");
          System.out.println("     SISTEMA DE GESTÃO DE SMART GRID (POO 1)     ");
          System.out.println("=================================================\n");

          MedidorInteligente medidor1 = new MedidorInteligente("00:1A:2B:3C:4D:01", 220.0);

          MedidorInteligente medidor2 = new MedidorInteligente("00:1A:2B:3C:4D:02");

          Consumidor consumidor1 = new Consumidor("Carlos Silva", "111.222.333-44", medidor1);
          Consumidor consumidor2 = new Consumidor("Ana Clara", "555.666.777-88", medidor2);

          medidor1.registrarConsumo(280);
          medidor1.registrarInjecaoSolar(80);

          medidor2.registrarConsumo(150);
          medidor2.registrarInjecaoSolar(320);

          System.out.println("-- Validando o Sistema --");
          medidor1.registrarConsumo(-15);
          medidor1.registrarConsumo(0);
          medidor1.setTensaoRede(275);


          //Rede no valor Padrão
          medidor1.setTensaoRede(220);
          System.out.println("---------------------------\n");

          System.out.println("--- EMISSÃO DE FATURAS ---");
          consumidor1.exibirRelatorioConsolidado();
          consumidor2.exibirRelatorioConsolidado();
     }
}