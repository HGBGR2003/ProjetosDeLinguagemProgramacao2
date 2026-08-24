package br.edu.ifgoiano.edu.alunos;

/**
 *  Representa um consumidor de energia elética vinculado a um medidor.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */

public class Consumidor {

    /**
     * Nome do consumidor, tipo privado, que só pode ser acessado pelo adiministrador do sistema.
     */
    private String nome;

    /**
     * Documento de identificação do consumidor (ex.: CPF ou CNPJ).
     */
    private String documento;

    /**
     * Medidor de energia associado ao consumidor.
     */
    private Medidor medidor;


    /**
     * Construtor da classe Consumidor.
     *
     * @param nome      Nome do consumidor.
     * @param documento Documento de identificação do consumidor.
     * @param medidor   Instância do medidor associado ao consumidor.
     */
    public Consumidor(String nome, String documento, Medidor medidor) {
        this.nome = nome;
        this.documento = documento;
        this.medidor = medidor;
    }

    /**
     * Obtém o nome do consumidor.
     *
     * @return O nome do consumidor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o documento de identificação do consumidor.
     *
     * @return O documento do consumidor.
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Obtém o medidor associado a este consumidor.
     *
     * @return O objeto {@link Medidor} vinculado.
     */
    public Medidor getMedidor() {
        return medidor;
    }



}
