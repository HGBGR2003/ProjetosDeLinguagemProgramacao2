public class AlunoEstagio extends Aluno implements RecebedorBolsa {
    private double bolsa;

    public AlunoEstagio(String nome, double dinheiro, int energia, double bolsa){
        super(nome, dinheiro, energia);
        this.bolsa = bolsa;
        System.out.println("Bolsa estágio: R$ " + this.bolsa);
    }

    public void trabalhar(){
        linha();
        this.setEnergia(this.getEnergia()-40);
        System.out.println(this.getNome() + " terminou o trabalho!");
        processarPagamentoBolsa();
    }

    @Override
    public void processarPagamentoBolsa() {
        linha();
        if (this.getBolsa() > 0){
            this.setDinheiro(this.getDinheiro() + this.bolsa);

            System.out.println("O Pagamento da bolsa no valor de R$ " + this.bolsa);
        }else{
            System.out.println("Valor da Bolsa Não Recebido, por isso não passou");
        }
        getStatus();
    }

    @Override
    public void estudar(){ //gasta 15 de energia
        linha();
        if(this.getEnergia() > 15){
            this.setEnergia(this.getEnergia() - 15);
            System.out.println(this.getNome() + " estudou!");
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER!");
        }
        getStatus();
    }

    public double getBolsa() {
        return bolsa;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }


}
