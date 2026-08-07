package br.edu.ifgoiano.edu.alunos;

public class Medidor {

    private String tipoDeMedidor;
    private String enderecoMac;
    private double valorConsumido;
    private double valorIngetado;
    private double [] tensoes;

    private final double Tminio = 90;
    private final double Tmaximo = 250;


    public Medidor(String enderecoMac, String tipoDeMedidor){
        this.enderecoMac = enderecoMac;
        this.tipoDeMedidor = tipoDeMedidor;
        this.tensoes = new double[
                tipoDeMedidor.equals("trifasico") ? 3 :
                tipoDeMedidor.equals("bifasico") ? 2 : 1
                ];

    }

    public void setTensao(int fase, double voltagem){
       if (fase >= tensoes.length){
           System.out.println("Fase Inválida.");
       }else if (voltagem < Tminio || voltagem > Tmaximo){
           System.out.println("Tensão bloqueada:" + voltagem + "V");
       }
       tensoes[fase] = voltagem;
    }

    public void registrarConsumo(double kwh){
        if (kwh > 0){
            valorConsumido += kwh;
        }else{
            System.out.println("Erro: Valor Inválido");
        }
    }

    public void registrarInjecao(double kwh){
        if (kwh > 0){
            valorIngetado += kwh;
        }
    }

    public String getMedidor() {
        return tipoDeMedidor;
    }

    public String getEnderecoMac() {
        return enderecoMac;
    }

    public double getValorIngetado() {
        return valorIngetado;
    }

    public double getValorConsumido() {
        return valorConsumido;
    }

    public double[] getTensoes() {
        return tensoes;
    }
}
