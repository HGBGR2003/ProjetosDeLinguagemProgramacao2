package br.edu.ifgoiano.edu.alunos;

/**
 * Representa um consumidor de energia elétrica vinculado a um medidor inteligente.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 2.1
 */
public class Consumidor {

    private String nome;
    private String documento;
    private MedidorInteligente medidor;

    /**
     * Construtor da classe Consumidor.
     * Valida a associação do medidor de forma estrutural (sem lançamento de exceções).
     *
     * @param nome      Nome do consumidor.
     * @param documento CPF ou CNPJ do consumidor.
     * @param medidor   Instância do medidor inteligente associado.
     */
    public Consumidor(String nome, String documento, MedidorInteligente medidor) {
        this.nome = nome;
        this.documento = documento;

        if (medidor != null) {
            this.medidor = medidor;
        } else {
            System.out.println("[ERRO] Medidor não informado para o consumidor " + nome + ".");
        }
    }

    /**
     * Exibe o relatório consolidado de forma simplificada e direta.
     */
    public void exibirRelatorioConsolidado() {
        if (this.medidor == null) {
            System.out.println("Não é possível gerar o relatório: Consumidor sem medidor associado.");
            return;
        }

        double consumo = this.medidor.getConsumoAcumuladoKWh();
        double geracao = this.medidor.getInjecaoAcumuladaKWh();
        double saldo = this.medidor.calcularSaldoConsumoLiquido();

        System.out.println("----- RELATÓRIO DO CONSUMIDOR -----");
        System.out.println("Cliente      : " + this.nome + " (" + this.documento + ")");
        System.out.println("Medidor (MAC): " + this.medidor.getMacAddress());
        System.out.printf("Consumo      : %.2f kWh%n", consumo);
        System.out.printf("Geração Solar: %.2f kWh%n", geracao);
        System.out.printf("Saldo Líquido: %.2f kWh%n", saldo);

        // Status simplificado
        if (saldo > 0) {
            System.out.printf("Status       : A PAGAR (%.2f kWh)%n", saldo);
        } else if (saldo < 0) {
            System.out.printf("Status       : CRÉDITO (%.2f kWh)%n", Math.abs(saldo));
        } else {
            System.out.println("Status       : ZERADO (Sem débitos)");
        }
        System.out.println("-----------------------------------\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public MedidorInteligente getMedidor() {
        return medidor;
    }

    public void setMedidor(MedidorInteligente medidor) {
        if (medidor != null) {
            this.medidor = medidor;
        } else {
            System.out.println("[ERRO] Não é permitido associar um medidor nulo.");
        }
    }
}