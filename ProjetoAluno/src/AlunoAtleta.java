public class AlunoAtleta extends Aluno implements RecebedorBolsa {
    private boolean treinar;
    private double bolsaEstagio;

    public AlunoAtleta(String nome, double dinheiro, int energia, boolean treinar, double bolsaEstagio) {
        super(nome, dinheiro, energia);
        this.treinar = treinar;
        this.bolsaEstagio = bolsaEstagio;
    }

    @Override
    public void processarPagamentoBolsa() {
        linha();
        if (this.bolsaEstagio > 0) {
            this.setDinheiro(this.getDinheiro() + this.bolsaEstagio);
            System.out.println("O Pagamento da bolsa no valor de R$ " + this.bolsaEstagio);
            linha();
        } else {
            System.out.println("Valor da Bolsa Não Recebido, por isso não passou");
        }
        getStatus();
    }

    @Override
    public void estudar() {
        linha();
        if (this.getEnergia() > 5) {
            this.setEnergia(this.getEnergia() - 5);
            System.out.println(this.getNome() + " estudou!");
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER!");
        }
        getStatus();
    }

    public void treinamento() {
        if (this.getEnergia() > 25) { // Ele pra treinar usa 25 de energia.
            this.setEnergia(this.getEnergia() - 25);
            this.treinar = true;
            System.out.println(this.getNome() + " treinou!");
            estudar();
        } else if (this.getEnergia() > 5) { //Estudando ele tira o 5.
            this.treinar = false;
            System.out.println(this.getNome() + " não tinha energia para treinar, mas ainda estudou!");
            estudar();
        } else {
            this.setEnergia(0);
            this.treinar = false;
            System.out.println("GAME OVER!");
        }
    }


}
