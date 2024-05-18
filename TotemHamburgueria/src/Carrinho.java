import java.util.ArrayList;

import produtos.Produto;

public class Carrinho {

    private ArrayList<Produto> produtos;

    public Carrinho()
    {
        produtos = new ArrayList<Produto>();
    }

    public Produto getProduto(int id){
        return produtos.get(id);
    }

    public void adicionarProduto(Produto p)
    {
        produtos.add(p.clonarProduto(produtos.size() + 1));
    }

    public void atualizarIds(int index_Inicial)
    {
        for (int i = index_Inicial - 1; i < produtos.size(); i++) {
            produtos.get(i).setId(i + 1);
        }
    }

    public void removerProdutoPorId(int id)
    {
        for (Produto p : produtos) {
            if (p.getId() == id)
            {
                produtos.remove(p);
                break;
            }
        }
        atualizarIds(id);
    }

    @Override
    public String toString() {
        String out = "===Carrinho===\n";
        for (Produto p : produtos) {
            out += p.getId() + " - " + p.toString() + "\n";
        }
        return out;
    }
}
