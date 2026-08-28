package br.edu.ifgoiano.edu.alunos;

/**
 * Representa um medidor de energia elétrica inteligente (Smart Grid),
 * responsável pelo monitoramento de tensão, consumo ativo e injeção solar.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 2.0
 */
public class MedidorInteligente {

    private String macAddress;
    private double consumoAcumuladoKWh;
    private double injecaoAcumuladaKWh;
    private double tensaoRede;

    private static final double TENSAO_MINIMA = 90.0;
    private static final double TENSAO_MAXIMA = 250.0;

    /**
     * Construtor de fábrica.
     * Encadeia para o construtor completo com tensão padrão de 220.0V.
     *
     * @param mac Endereço MAC do medidor.
     */
    public MedidorInteligente(String mac) {
        this(mac, 220.0);
    }

    /**
     * Construtor completo.
     *
     * @param mac    Endereço MAC do medidor.
     * @param tensao Tensão inicial da rede elétrica.
     */
    public MedidorInteligente(String mac, double tensao) {
        this.macAddress = mac;
        this.consumoAcumuladoKWh = 0.0;
        this.injecaoAcumuladaKWh = 0.0;
        setTensaoRede(tensao); // Utiliza o setter para aplicar a validação física
    }

    /**
     * Define e monitora a tensão da rede aplicando proteção contra sobre/subtensão.
     *
     * @param tensao Tensão em Volts (V).
     */
    public void setTensaoRede(double tensao) {
        if (tensao >= TENSAO_MINIMA && tensao <= TENSAO_MAXIMA) {
            this.tensaoRede = tensao;
        } else {
            this.tensaoRede = 0.0;
            System.out.println("[ALERTA CRÍTICO] Disjuntor acionado no medidor MAC: " + this.macAddress
                    + " | Tensão fora dos limites (" + tensao + "V). Alimentação cortada (0.0V).");
        }
    }

    /**
     * Registra consumo de energia ativa em kWh.
     *
     * @param kwh Valor em kWh estritamente maior que 0.0.
     */
    public void registrarConsumo(double kwh) {
        if (kwh > 0.0) {
            this.consumoAcumuladoKWh += kwh;
        } else {
            System.out.println("[ERRO TELEMETRIA] MAC: " + this.macAddress
                    + " | Consumo inválido (" + kwh + " kWh). O valor deve ser maior que zero.");
        }
    }

    /**
     * Registra injeção de energia solar na rede em kWh.
     *
     * @param kwh Valor em kWh estritamente maior que 0.0.
     */
    public void registrarInjecaoSolar(double kwh) {
        if (kwh > 0.0) {
            this.injecaoAcumuladaKWh += kwh;
        } else {
            System.out.println("[ERRO TELEMETRIA] MAC: " + this.macAddress
                    + " | Injeção solar inválida (" + kwh + " kWh). O valor deve ser maior que zero.");
        }
    }

    /**
     * Calcula o saldo líquido de energia (Consumo - Injeção Solar).
     *
     * @return Saldo de consumo líquido em kWh.
     */
    public double calcularSaldoConsumoLiquido() {
        return this.consumoAcumuladoKWh - this.injecaoAcumuladaKWh;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public double getConsumoAcumuladoKWh() {
        return consumoAcumuladoKWh;
    }

    public double getInjecaoAcumuladaKWh() {
        return injecaoAcumuladaKWh;
    }

    public double getTensaoRede() {
        return tensaoRede;
    }
}