package br.edu.ifgoiano.encontros;

/**
 * Representa a estrutura base abstrata de um Robô de Combate.
 * Gerencia os atributos fundamentais como nome, pontos de vida e peso em quilogramas (kg),
 * além de definir o contrato para o método de ataque entre robôs adversários.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public abstract class RoboCombate {

    /**
     * Nome identificador do robô de combate.
     */
    private String nome;

    /**
     * Quantidade atual de pontos de vida (HP) do robô.
     */
    private double vida;

    /**
     * Peso do robô em quilogramas (kg).
     */
    private double pesoKg;

    /**
     * Construtor da classe abstrata RoboCombate.
     * Inicializa os atributos com validações para evitar nomes vazios, valores negativos
     * de vida ou pesos inválidos.
     *
     * @param nome   Nome do robô de combate.
     * @param vida   Pontos de vida iniciais (deve ser maior que zero).
     * @param pesoKg Peso do robô em kg (deve ser maior que zero).
     */
    public RoboCombate(String nome, double vida, double pesoKg) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("O robô não possui nome, coloque um nome, ou o Nome Padrão: Robô Do");
            this.nome = "Robô Do";
        }

        if (vida > 0) {
            this.vida = vida;
        } else {
            System.out.println("Não pode ter vida negativa, vida padrão fica com 0");
            this.vida = 0;
        }

        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        } else {
            System.out.println("Peso Negativo, não pode, por isso o peso padrão é de um 1Kg");
            this.pesoKg = 0;
        }
    }

    /**
     * Executa a ação de ataque contra um robô adversário.
     * Deve ser implementado pelas subclasses de acordo com o tipo e poder de ataque de cada robô.
     *
     * @param adversario Instância do {@link RoboCombate} adversário que receberá o ataque.
     */
    public abstract void atacar(RoboCombate adversario);

    /**
     * Obtém o nome do robô de combate.
     *
     * @return O nome do robô.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define ou altera o nome do robô, validando para não aceitar textos vazios ou nulos.
     *
     * @param nome Novo nome para o robô.
     */
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    /**
     * Obtém a quantidade atual de pontos de vida do robô.
     *
     * @return Os pontos de vida.
     */
    public double getVida() {
        return vida;
    }

    /**
     * Define ou atualiza os pontos de vida do robô, garantindo que a vida não fique negativa.
     *
     * @param vida Novos pontos de vida do robô.
     */
    public void setVida(double vida) {
        if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    /**
     * Obtém o peso do robô em quilogramas (kg).
     *
     * @return O peso em kg.
     */
    public double getPesoKg() {
        return pesoKg;
    }

    /**
     * Define ou atualiza o peso do robô em kg, aceitando apenas valores positivos.
     *
     * @param pesoKg Novo peso em kg.
     */
    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
    }
}