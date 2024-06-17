// Empresa.java
public abstract class Empresa {
    private String nome;

    public Empresa() {
    }

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
