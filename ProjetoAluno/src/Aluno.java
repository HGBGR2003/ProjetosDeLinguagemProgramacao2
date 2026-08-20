public class Aluno {

    private int energia;
    private double dinheiro;
    private String nome;

    public Aluno(String nome){
        this.nome = nome;
        this.energia = 100;
        this.dinheiro = 200;
        linha();
        System.out.println("Novo aluno matriculado!");
        getStatus();
    }

    public Aluno(String nome, double dinheiro, int energia){
        this.nome = nome;
        this.energia = energia;
        this.dinheiro = dinheiro;
        linha();
        System.out.println("Novo aluno matriculado!");
        getStatus();
    }

    public void recebePIX(double valor){
        linha();
        if(valor > 0){
            this.dinheiro += valor;
            System.out.println(this.nome + " recebeu um PIX de R$ " + valor);
        }else{
            System.out.println("Valor inválido!");
        }
        getStatus();
    }

    public void beberCafe(){
        linha();
        if(this.dinheiro >= 5){
            this.dinheiro -= 5;
            this.energia += 15;
            System.out.println(this.nome + " bebeu café!");
        } else {
            System.out.println(this.nome + " está quebrado! Sem dinheiro pro café!");
        }
        getStatus();
    }

    public void beberEnergetico(){
        linha();
        if(this.dinheiro >= 20){
            this.dinheiro -= 20;
            this.energia += 25;
            System.out.println(this.nome + " bebeu energético!");
        } else {
            System.out.println(this.nome + " está quebrado! Sem dinheiro pro energético!");
        }
        getStatus();
    }

    public void estudar(){
        linha();
        if(this.energia > 30){
            this.energia -= 30;
            System.out.println(this.nome + " estudou!");
        } else {
            this.energia = 0;
            System.out.println("GAME OVER!");
        }
        getStatus();
    }

    public String getNome(){
        return this.nome;
    }

    public int getEnergia(){
        return this.energia;
    }

    public double getDinheiro(){
        return this.dinheiro;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public void setDinheiro(double dinheiro){
        this.dinheiro = dinheiro;
    }

    public void linha(){
        System.out.println("--------------------------");
    }

    public void getStatus(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Energia: " + this.energia);
        System.out.println("Dinheiro: R$ " + this.dinheiro);
    }
}
