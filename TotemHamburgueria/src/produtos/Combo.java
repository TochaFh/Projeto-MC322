package produtos;

import java.util.ArrayList;

public class Combo extends Produto{
    
    private static double desconto = 0.15;
    private ArrayList<ProdutoSimples> produtosNoCombo;
    
    public Combo() {
        produtosNoCombo = new ArrayList<ProdutoSimples>();
    }

    @Override
    public double calcularPreco() {

        double preco = 0;
        for (ProdutoSimples p : produtosNoCombo) {
            preco += p.calcularPreco();
        }

        return preco - (desconto * preco);
    }

    @Override
    public Produto clonarProduto(int novoId) {
        Combo clone = new Combo();
        clone.descricao = descricao;
        clone.id = novoId;
        clone.nome = nome;

        for (ProdutoSimples p : produtosNoCombo) {
            clone.produtosNoCombo.add((ProdutoSimples)p.clonarProduto(p.id));
        }

        return clone;
    }

    @Override
    public void definirOpcoes() {
        for (ProdutoSimples p : produtosNoCombo) {
            p.definirOpcoes();
        }
    }

}
