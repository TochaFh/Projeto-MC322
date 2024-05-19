package produtos;

public abstract class Produto {

    protected int id;
    protected String nome;
    protected String descricao;

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // toString basico
    @Override
    public String toString() {
        return nome;
    }

    // Metodos abstratos

    public abstract double calcularPreco();

    public abstract Produto clonarProduto(int novoId);

    public abstract void definirOpcoes();
}
