package produtos;

import java.util.ArrayList;

public class Combo extends Produto {

    private static double desconto = 0.15;
    private ArrayList<ProdutoSimples> produtosNoCombo;

    public Combo() {
        produtosNoCombo = new ArrayList<ProdutoSimples>();
    }

    public Combo(String nome, ArrayList<ProdutoSimples> produtosNoCombo) {
        this.nome = nome;
        this.produtosNoCombo = produtosNoCombo;
    }

    // Calcula o preco total do combo
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
            clone.produtosNoCombo.add((ProdutoSimples) p.clonarProduto(p.id));
        }

        return clone;
    }

    // Define os tamanhos e tipos dos produtos do combo
    @Override
    public void definirOpcoes() {
        //System.out.println("*OPÇÕES DO COMBO");
        //int i = 1;
        for (ProdutoSimples p : produtosNoCombo) {
            //System.out.println(i + ". " + p.nome + ":");
            p.definirOpcoes();
            //i++;
        }
    }

    @Override
    public String toString() {
        String out = nome + " - ";
        for (ProdutoSimples p : produtosNoCombo) {
            out += p.nome + "; ";
        }
        return out;
    }

}
