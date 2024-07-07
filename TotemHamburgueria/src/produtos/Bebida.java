package produtos;

import javax.swing.JOptionPane;

import application.App;
import enumeration.Tamanho;

public class Bebida extends ProdutoSimples {

    Tamanho tamanho;

    public Bebida() {
        this.tamanho = Tamanho.INDEFINIDO;
        this.preco = -1;
        this.nome = "Bebida";
    }

    @Override
    public double calcularPreco() {
        if (tamanho == Tamanho.PEQUENO) {
            return 4;
        } else if (tamanho == Tamanho.MEDIO) {
            return 8;
        } else if (tamanho == Tamanho.GRANDE) {
            return 12;
        }
        return 0;
    }

    @Override
    public Produto clonarProduto(int novoId) {
        Bebida clone = new Bebida();
        clone.descricao = descricao;
        clone.nome = nome;
        clone.id = novoId;
        clone.preco = preco;
        clone.tamanho = tamanho;
        return clone;
    }

    static String[] OPCOES_TAMANHO = {"Pequena", "Média", "Grande"};



    // Define o tamanho e o tipo de bebida escolhido pelo cliente
    @Override
    public void definirOpcoes() {
        
        int opcao = JOptionPane.showOptionDialog(null,
                                    "Qual o tamanho da BEBIDA?",
                                    "Tamanho bebida",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    OPCOES_TAMANHO,
                                    "Média");

        String tam;
        switch (opcao) {
            case 0:
                this.tamanho = Tamanho.PEQUENO;
                tam = "pequeno(a)";
                break;
            case 1:
                this.tamanho = Tamanho.MEDIO;
                tam = "médio(a)";
                break;
            case 2:
                this.tamanho = Tamanho.GRANDE;
                tam = "grande";
                break;
            default:
                tam = "problema";
                break;
        }

            
        String[] tiposBebida = App.getDADOS().getTiposDeBebida();

        opcao = JOptionPane.showOptionDialog(null,
                                    "Qual será a bebida?",
                                    "Escolha bebida",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    tiposBebida,
                                    tiposBebida[0]);

        
        this.nome = tiposBebida[opcao] + " " + tam;
    }
}