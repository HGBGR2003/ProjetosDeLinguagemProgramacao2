public class AlunoAtleta extends Aluno {
    private boolean treinar;

    public AlunoAtleta(String nome, double dinheiro, int energia, boolean treinar) {
        super(nome, dinheiro, energia);
        this.treinar = treinar;
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
