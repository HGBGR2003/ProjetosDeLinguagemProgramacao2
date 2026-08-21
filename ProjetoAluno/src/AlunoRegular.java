public class AlunoRegular extends Aluno {
    private double matricula;

    public AlunoRegular(String nome, double matricula) {
        super(nome, 200, 100);
        this.matricula = matricula;
    }

    @Override
    public void estudar() {
        linha();
        if (this.getEnergia() > 30) {
            this.setEnergia(this.getEnergia() - 30);
            System.out.println(this.getNome() + " estudou!");
        } else {
            this.setEnergia(0);
            System.out.println("GAME OVER");
        }
        getStatus();
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }
}
