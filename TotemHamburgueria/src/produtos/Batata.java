package produtos;

import javax.swing.JOptionPane;

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

    // Define o tamanho escolhido pelo cliente
    @Override
    public void definirOpcoes() {
        
        int opcao = JOptionPane.showOptionDialog(null,
                                    "Qual o tamanho da BATATA?",
                                    "Tamanho batata",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    Bebida.OPCOES_TAMANHO,
                                    "Média");
        String tam;
        switch (opcao) {
            case 0:
                this.tamanho = Tamanho.PEQUENO;
                tam = "pequena";
                break;
            case 1:
                this.tamanho = Tamanho.MEDIO;
                tam = "média";
                break;
            case 2:
                this.tamanho = Tamanho.GRANDE;
                tam = "grande";
                break;
            default:
                tam = "problema";
                break;
        }

        this.nome = "Batata " + tam;
    }
}
