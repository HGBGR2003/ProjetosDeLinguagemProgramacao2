package br.edu.ifgoiano.edu.alunos;

/**
 * Representa um medidor de energia elétrica, responsável pelo monitoramento
 * de tensões por fase, registro de consumo e injeção de energia na rede.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public class Medidor {

    /**
     * Tipo do medidor elétrico (ex.: "monofasico", "bifasico", "trifasico").
     */
    private String tipoDeMedidor;

    /**
     * Endereço físico MAC do dispositivo medidor.
     */
    private String enderecoMac;

    /**
     * Quantidade total de energia consumida em quilowatt-hora (kWh).
     */
    private double valorConsumido;

    /**
     * Quantidade total de energia injetada na rede em quilowatt-hora (kWh).
     */
    private double valorIngetado;

    /**
     * Vetor que armazena os valores de tensão (em Volts) para cada fase.
     */
    private double[] tensoes;

    /**
     * Limite mínimo permitido de tensão elétrica (em Volts).
     */
    private final double Tminio = 90;

    /**
     * Limite máximo permitido de tensão elétrica (em Volts).
     */
    private final double Tmaximo = 250;

    /**
     * Construtor da classe Medidor. Inicializa o endereço MAC, o tipo de medidor
     * e dimensiona o vetor de tensões de acordo com o número de fases.
     *
     * @param enderecoMac   Endereço MAC do medidor.
     * @param tipoDeMedidor Tipo do medidor ("monofasico", "bifasico", "trifasico").
     */
    public Medidor(String enderecoMac, String tipoDeMedidor) {
        this.enderecoMac = enderecoMac;
        this.tipoDeMedidor = tipoDeMedidor;

        String tipoNormalizado = tipoDeMedidor.toLowerCase()
                .replace("á", "a")
                .replace("ã", "a");

        this.tensoes = new double[
                tipoNormalizado.equals("trifasico") ? 3 :
                        tipoNormalizado.equals("bifasico") ? 2 : 1
                ];
    }

    /**
     * Define e registra o valor de tensão para uma fase específica, validando
     * se a fase existe e se a voltagem está dentro dos limites permitidos (90V a 250V).
     *
     * @param fase     Índice da fase (iniciando em 0).
     * @param voltagem Valor da tensão em Volts (V).
     */
    public void setTensao(int fase, double voltagem) {
        if (fase < 0 || fase >= tensoes.length) {
            System.out.println("Fase Inválida.");
            return;
        }
        if (voltagem < Tminio || voltagem > Tmaximo) {
            System.out.println("Tensão bloqueada: " + voltagem + "V");
            return;
        }
        tensoes[fase] = voltagem;
    }

    /**
     * Registra um consumo de energia adicionando a quantidade informada ao total acumulado.
     *
     * @param kwh Quantidade de energia consumida em quilowatt-hora (deve ser maior que zero).
     */
    public void registrarConsumo(double kwh) {
        if (kwh > 0) {
            valorConsumido += kwh;
        } else {
            System.out.println("Erro: Valor Inválido");
        }
    }

    /**
     * Registra uma injeção de energia na rede adicionando a quantidade informada ao total injetado.
     *
     * @param kwh Quantidade de energia injetada em quilowatt-hora (deve ser maior que zero).
     */
    public void registrarInjecao(double kwh) {
        if (kwh > 0) {
            valorIngetado += kwh;
        } else {
            System.out.println("Erro: Valor Inválido");
        }
    }

    /**
     * Obtém o tipo do medidor configurado.
     *
     * @return O tipo do medidor (ex.: "monofasico", "bifasico", "trifasico").
     */
    public String getMedidor() {
        return tipoDeMedidor;
    }

    /**
     * Obtém o endereço MAC do medidor.
     *
     * @return O endereço MAC em formato de texto.
     */
    public String getEnderecoMac() {
        return enderecoMac;
    }

    /**
     * Obtém o total de energia injetada acumulada.
     *
     * @return O valor injetado em kWh.
     */
    public double getValorIngetado() {
        return valorIngetado;
    }

    /**
     * Obtém o total de energia consumida acumulada.
     *
     * @return O valor consumido em kWh.
     */
    public double getValorConsumido() {
        return valorConsumido;
    }

    /**
     * Obtém o vetor contendo as tensões registradas por fase.
     *
     * @return Array de {@code double} contendo as tensões em Volts.
     */
    public double[] getTensoes() {
        return tensoes;
    }
}