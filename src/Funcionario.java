public abstract class Funcionario {
    private String nome;
    private int idade;
    private double salarioBase;

    public Funcionario() {
    }

    public Funcionario(String nome, int idade, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Salário Base: " + salarioBase;
    }
}
