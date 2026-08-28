/**
 * Classe principal de execução e teste do sistema "UNIVERSITÁRIO PERRENGUE SIMULATOR".
 * Demonstra na prática os principais pilares e relações da Programação Orientada a Objetos:
 * <ul>
 *   <li><b>Herança e Polimorfismo:</b> Especializações de {@link Aluno} (Regular, Estágio, Atleta).</li>
 *   <li><b>Associação:</b> Relação de uso entre {@link AlunoRegular} e {@link Computador}.</li>
 *   <li><b>Agregação:</b> Coleção de {@link Aluno} gerenciada pela {@link Republica}.</li>
 *   <li><b>Composição:</b> Vínculo vitalício entre {@link AlunoRegular} e {@link HistoricoAcademico}.</li>
 * </ul>
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Aluno
 * @see AlunoRegular
 * @see AlunoEstagio
 * @see AlunoAtleta
 * @see Computador
 * @see Republica
 * @see HistoricoAcademico
 */
    /**
     * Ponto de entrada do simulador. Executa cenários completos de testes
     * para demonstrar as regras de negócio e os relacionamentos entre os objetos.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("UNIVERSITÁRIO PERRENGUE SIMULATOR");
        System.out.println("=================================");

        // Teste de Aluno Regular
        AlunoRegular alu1 = new AlunoRegular("Danilo", 2022.22044);
        alu1.recebePIX(1000);
        alu1.beberCafe();
        alu1.beberEnergetico();

        // Teste de Aluno Estagiário
        AlunoEstagio aluno2 = new AlunoEstagio("Henrique", 2000, 150, 2000);
        aluno2.trabalhar();
        aluno2.estudar();

        // Teste de Aluno Atleta
        AlunoAtleta aluno3 = new AlunoAtleta("João", 2000, 150, true, 3000);
        aluno3.processarPagamentoBolsa();
        aluno3.treinamento();

        AlunoRegular alu2 = new AlunoRegular("Mario", 2022);

        // Demonstração de Associação (Aluno e Computador)
        alu2.programarJava();
        Computador pc = new Computador("Dell");
        alu2.setComputador(pc);
        alu2.programarJava();

        // Demonstração de Agregação (República e Alunos)
        Republica ceu = new Republica("CEU - Casa do Estudante Universitário");
        ceu.acolherAluno(alu1);
        ceu.acolherAluno(aluno2);
        ceu.acolherAluno(aluno3);
        ceu.expulsarAluno(alu1);
        alu1.getStatus(); // Mesmo após ser expulso, o aluno continua existindo de forma independente

        // Demonstração de Composição (Aluno e Histórico Acadêmico)
        alu1.tirarNotaBaixa();
    }
