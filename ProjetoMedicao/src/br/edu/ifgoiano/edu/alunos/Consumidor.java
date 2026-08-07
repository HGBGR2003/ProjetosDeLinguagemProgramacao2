package br.edu.ifgoiano.edu.alunos;

public class Consumidor {

    private String nome;
    private String documento;
    private Medidor medidor;

    public Consumidor(String nome, String documento, Medidor medidor) {
        this.nome = nome;
        this.documento = documento;
        this.medidor = medidor;
    }

    public String getNome() {
        return nome;
    }


    public String getDocumento() {
        return documento;
    }

    public Medidor getMedidor() {
        return medidor;
    }



}
