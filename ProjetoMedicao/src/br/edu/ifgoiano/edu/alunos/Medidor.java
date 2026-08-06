package br.edu.ifgoiano.edu.alunos;

public class Medidor {

    private String medidor;
    private String enderecoMac;
    private double valorConsumido;
    private double valorIngetado;
    private double [] tensoes;

    private final double Tminio = 90, Tmaximo = 250;


    public Medidor(String enderecoMac, String medidor){
        this.enderecoMac = enderecoMac;
        this.medidor = medidor;
        this.tensoes = new double[
                medidor.equals("trifasico") ? 3 :
                medidor.equals("bifasico") ? 2 : 1
                ];
    }

    public void setTensao(int fase, double v){
        //Ainda Não terminado
    }

    public void registrarConsumo(double kwh){
        //Ainda Não terminado
    }

    public void registrarInjecao(double kwh){
        //Ainda Não terminado
    }

    public String getMedidor() {
        return medidor;
    }

    public String getEnderecoMac() {
        return enderecoMac;
    }

    public double getValorIngetado() {
        return valorIngetado;
    }

    public void setValorIngetado(double valorIngetado) {
        this.valorIngetado = valorIngetado;
    }

    public double getValorConsumido() {
        return valorConsumido;
    }

    public void setValorConsumido(double valorConsumido) {
        this.valorConsumido = valorConsumido;
    }
}
