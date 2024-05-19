package produtos;

import application.App;
import enumeration.Tamanho;

public class Batata extends ProdutoSimples {

    private Tamanho tamanho;

    public Batata() {
        this.tamanho = Tamanho.INDEFINIDO;
        this.preco = -1;
        this.nome = "Batata";
    }

    @Override
    public double calcularPreco() {
        if (tamanho == Tamanho.PEQUENO) {
            return 5;
        } else if (tamanho == Tamanho.MEDIO) {
            return 10;
        } else if (tamanho == Tamanho.GRANDE) {
            return 15;
        }
        return 0;
    }

    @Override
    public Produto clonarProduto(int novoId) {
        Batata clone = new Batata();
        clone.descricao = descricao;
        clone.nome = nome;
        clone.id = novoId;
        clone.preco = preco;
        clone.tamanho = tamanho;
        return clone;
    }

    @Override
    public void definirOpcoes() {
        System.out
                .println("Qual tamanho da batata? (P) - Pequena, R$5,00; (M) - Media, R$10,00 (G) - Grande, R$15,00: ");
        String tam = "";
        String opcao = App.readNext();
        switch (opcao) {
            case "P":
                this.tamanho = Tamanho.PEQUENO;
                tam = "pequena";
                break;
            case "M":
                this.tamanho = Tamanho.MEDIO;
                tam = "média";
                break;
            case "G":
                this.tamanho = Tamanho.GRANDE;
                tam = "grande";
                break;
        }
        this.nome = "Batata " + tam;
    }
}
