package dados;

import java.util.ArrayList;
import produtos.Produto;
import java.util.Locale;
import java.text.NumberFormat;

public class Carrinho {

    private ArrayList<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<Produto>();
    }

    // Retorna o produto pelo seu id
    public Produto getProduto(int id) {
        return produtos.get(id - 1);
    }

    // Adiciona a referência do produto direto, sem clonar ou definir opções
    // Apenas altera o id para condizer com a ordem no carrinho
    public void adicionarProdutoDireto(Produto p) {
        produtos.add(p);
        p.setId(produtos.size());
    }

    // Adiciona clone do produto e define as opções dele
    public void adicionarProduto(Produto p) {
        Produto novo = p.clonarProduto(produtos.size() + 1);
        produtos.add(novo);
        novo.definirOpcoes();
    }

    // Reorganiza os Ids quando algum item é removido
    public void atualizarIds(int index_Inicial) {
        for (int i = index_Inicial - 1; i < produtos.size(); i++) {
            produtos.get(i).setId(i + 1);
        }
    }

    // Remove o produto pelo id da ArrayList
    public void removerProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                produtos.remove(p);
                break;
            }
        }
        atualizarIds(id);
    }

    // Calcula a soma dos preços dos produtos
    public String calculaTotal() {
        Locale ptBr = new Locale("pt", "BR");
        double preco = 0;
        for (Produto p : produtos) {
            preco += p.calcularPreco();
        }
        return NumberFormat.getCurrencyInstance(ptBr).format(preco);
    }

    @Override
    public String toString() {
        Locale ptBr = new Locale("pt", "BR");
        String out = "";
        for (Produto p : produtos) {
            out += p.getId() + " - " + p.toString();
            double preco = p.calcularPreco();
            if (preco > 0) {
                out += " - " + NumberFormat.getCurrencyInstance(ptBr).format(preco);
            }
            out += "\n";
        }

        if (out == "")
            out = "vazio";

        return out;
    }
}
