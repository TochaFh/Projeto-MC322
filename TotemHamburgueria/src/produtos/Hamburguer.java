package produtos;

public class Hamburguer extends ProdutoSimples {

    public Hamburguer() {

    }

    public Hamburguer(String nome, String descricao, int preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }

    @Override
    public Produto clonarProduto(int novoId) {
        Hamburguer clone = new Hamburguer();
        clone.descricao = descricao;
        clone.nome = nome;
        clone.id = novoId;
        clone.preco = preco;
        return clone;
    }

    @Override
    public void definirOpcoes() {
        // Nao existem opcoes a serem definidas
    }

}
