public class Diretor extends Funcionario {
    private double participacaoLucros;

    public Diretor() {
    }

    public Diretor(String nome, int idade, double salarioBase, double participacaoLucros) {
        super(nome, idade, salarioBase);
        this.participacaoLucros = participacaoLucros;
    }

    public double getParticipacaoLucros() {
        return participacaoLucros;
    }

    public void setParticipacaoLucros(double participacaoLucros) {
        this.participacaoLucros = participacaoLucros;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + participacaoLucros;
    }

    @Override
    public String toString() {
        return "Diretor - " + super.toString() + ", Participação nos Lucros: " + participacaoLucros;
    }
}
