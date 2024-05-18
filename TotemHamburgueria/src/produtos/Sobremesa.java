package produtos;

public class Sobremesa extends ProdutoSimples {

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
