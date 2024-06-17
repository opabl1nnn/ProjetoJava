public class Operador extends Funcionario {
    private double horasExtras;

    public Operador() {
    }

    public Operador(String nome, int idade, double salarioBase, double horasExtras) {
        super(nome, idade, salarioBase);
        this.horasExtras = horasExtras;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (horasExtras * 20);
    }

    @Override
    public String toString() {
        return "Operador - " + super.toString() + ", Horas Extras: " + horasExtras;
    }
}
