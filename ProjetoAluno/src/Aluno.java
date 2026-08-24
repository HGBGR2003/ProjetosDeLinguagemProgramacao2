/**
 * Representa a estrutura base abstrata de um Aluno, gerenciando seus atributos
 * Essenciais de estado como nome, energia vital e saldo financeiro, além de
 * Ações cotidianas como receber PIX e consumir bebidas energéticas.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */

public abstract class Aluno {
    /**
     * Nível atual de energia do aluno.
     */
    private int energia;
    /**
     * Quantidade de dinheiro disponível em reais (R$).
     */
    private double dinheiro;
    /**
     * Nome completo do aluno.
     */
    private String nome;

    /**
     * Construtor da classe abstrata Aluno.
     * Inicializa os atributos essenciais e exibe a mensagem de nova matrícula com o status inicial.
     *
     * @param nome     Nome do aluno.
     * @param dinheiro Saldo financeiro inicial em reais (R$).
     * @param energia  Quantidade inicial de energia.
     */
    public Aluno(String nome, double dinheiro, int energia) {
        this.nome = nome;
        this.energia = energia;
        this.dinheiro = dinheiro;
        linha();
        System.out.println("Novo aluno matriculado!");
        getStatus();
    }

    /**
     * Credita um valor financeiro recebido via PIX ao saldo do aluno, validando se o valor informado é positivo.
     * @param valor Quantia em reais a ser creditada (deve ser maior que zero).
     */
    public void recebePIX(double valor) {
        linha();
        if (valor > 0) {
            this.dinheiro += valor;
            System.out.println(this.nome + " recebeu um PIX de R$ " + valor);
        } else {
            System.out.println("Valor inválido!");
        }
        getStatus();
    }

    /**
     * Simula o consumo de café pelo aluno.
     * Custa R$ 5,00 e restaura 15 pontos de energia, caso haja saldo suficiente.
     */
    public void beberCafe() {
        linha();
        if (this.dinheiro >= 5) {
            this.dinheiro -= 5;
            this.energia += 15;
            System.out.println(this.nome + " bebeu café!");
        } else {
            System.out.println(this.nome + " está quebrado! Sem dinheiro pro café!");
        }
        getStatus();
    }


    /**
     * Simula o consumo de energético pelo aluno.
     * Custa R$ 20,00 e restaura 25 pontos de energia, caso haja saldo suficiente.
     */
    public void beberEnergetico() {
        linha();
        if (this.dinheiro >= 20) {
            this.dinheiro -= 20;
            this.energia += 25;
            System.out.println(this.nome + " bebeu energético!");
        } else {
            System.out.println(this.nome + " está quebrado! Sem dinheiro pro energético!");
        }
        getStatus();
    }

    /**
     * Metodo abstrato que define a ação de estudar.
     * Deve ser implementado pelas subclasses de acordo com suas regras específicas.
     */
    public abstract void estudar();

    /**
     * Obtém o nome do aluno.
     * @return O nome do aluno.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Obtém a quantidade atual de energia do aluno.
     * @return A energia atual.
     */
    public int getEnergia() {
        return this.energia;
    }

    /**
     * Obtém o saldo financeiro atual do aluno em reais.
     * @return O valor em dinheiro disponível.
     */
    public double getDinheiro() {
        return this.dinheiro;
    }

    /**
     * Define/atualiza a quantidade de energia do aluno.
     * @param energia Nova quantidade de energia.
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    /**
     * Define/atualiza o saldo financeiro do aluno.
     * @param dinheiro Novo valor em dinheiro.
     */
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     * Imprime uma linha separadora no console para organização visual da saída.
     */
    public void linha() {
        System.out.println("--------------------------");
    }

    /**
     * Imprime no console o status atual do aluno (nome, energia e dinheiro).
     */
    public void getStatus() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Energia: " + this.energia);
        System.out.println("Dinheiro: R$ " + this.dinheiro);
    }
}
