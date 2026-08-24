/**
 * Classe principal de teste para a simulação "UNIVERSITÁRIO PERRENGUE SIMULATOR",
 * instanciando e executando as ações dos diferentes tipos de alunos.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */

void main() {
    System.out.println("UNIVERSITÁRIO PERRENGUE SIMULATOR");
    System.out.println("=================================");

//    Aluno alu1 = new AlunoRegular("Danilo", 2022.22044);
//    alu1.recebePIX(1000);
//    alu1.beberCafe();
//    alu1.beberEnergetico();

//    AlunoEstagio aluno2 = new AlunoEstagio("Henrique", 2000, 150, 2000);
//    aluno2.trabalhar();
//    aluno2.estudar();

    AlunoAtleta aluno3 = new AlunoAtleta("João", 2000, 150, true, 3000);
    aluno3.processarPagamentoBolsa();
    aluno3.treinamento();

    //aluno1.recebePIX(-10);
    //aluno1.beberEnergetico();
    //aluno1.estudar();

}

