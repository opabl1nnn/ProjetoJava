public class Gerente extends Funcionario {
    private double bonus;

    public Gerente() {
    }

    public Gerente(String nome, int idade, double salarioBase, double bonus) {
        super(nome, idade, salarioBase);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonus;
    }

    @Override
    public String toString() {
        return "Gerente - " + super.toString() + ", Bônus: " + bonus;
    }
}
