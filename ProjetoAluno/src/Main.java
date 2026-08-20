
void main() {
    System.out.println("UNIVERSITÁRIO PERRENGUE SIMULATOR");
    System.out.println("=================================");
    Aluno aluno1 = new Aluno("Diego");

    AlunoEstagio aluno2 = new AlunoEstagio("Henrique", 2000, 150, 2000);
    aluno2.trabalhar();
    aluno2.estudar();

    //aluno1.recebePIX(-10);
    //aluno1.beberEnergetico();
    //aluno1.estudar();

    //System.out.println("ANALISANDO OS ESTUDANTES DO CEU");
    //List<Aluno> ceu = new ArrayList<>(); //Collections, veremos mais pra frente
    //ceu.add(aluno1);
    //ceu.add(aluno2);
    //for (Aluno aluno : ceu){
    //  aluno.estudar();
    //  aluno.beberCafe();
}

