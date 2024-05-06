public abstract class Produto {

    private int id;
    private String nome;
    private String descricao;

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

    // toString básico
    @Override
    public String toString() {
        return nome;
    }

    
    // Métodos abstratos

    public abstract double calcularPreco();

    public abstract Produto clonar();

    public abstract boolean definirOpcoes();
}
