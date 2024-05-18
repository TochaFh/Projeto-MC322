package produtos;

import java.util.Scanner;
import enumeration.Tamanho;

public class Batata extends ProdutoSimples {

    private Tamanho tamanho;

    public Batata()
    {
        this.tamanho = Tamanho.INDEFINIDO;
        this.preco = -1;
        this.nome = "Batata [tamanho a definir]";
    }
    
    @Override
    public double calcularPreco() {
        if (tamanho == Tamanho.PEQUENO){
            return 5;
        }
        else if (tamanho == Tamanho.MEDIO){
            return 10;
        }
        else if (tamanho == Tamanho.GRANDE){
            return 15;
        }
        return -1;
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
        Scanner inputOpcao = new Scanner(System.in);
        System.out.println("Qual tamanho da batata? (P) - Pequena, R$5,00; (M) - Media, R$10,00 (G) - Grande, R$15,00: ");

        inputOpcao.close();
    }
}
