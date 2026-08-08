package br.edu.ifgoiano.edu.alunos;

public class Main {
   public static void main(String[] args) {
        Medidor medidor = new Medidor("00:1A:2B:3C:4D:4E","bifásico");

        medidor.registrarConsumo(10.5);
        //medidor.registrarConsumo(-3); //Irá dar erro, pois o consumo não pode ser negativo!

        medidor.setTensao(0,220);
        medidor.setTensao(0,210);
        //medidor.setTensao(2,290); // Passou do limite que está entre 90V á 250V.

        medidor.registrarInjecao(3.2);

        Consumidor consumidor = new Consumidor("Henrique Gabriel Barbosa Guida", "6627595724", medidor);

        System.out.println("Consumidor: " + consumidor.getNome());
        System.out.println("MAC: " + medidor.getEnderecoMac());
        System.out.println("Consumo: " + medidor.getValorConsumido() + "kwh");

    }
}
