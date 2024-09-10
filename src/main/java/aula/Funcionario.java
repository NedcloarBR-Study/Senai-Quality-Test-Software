package aula;

public class Funcionario {
    private int id;
    private String nome;
    private String setor;

    public Funcionario(int id, String nome, String setor) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", setor=" + setor + "]";
    }
}
