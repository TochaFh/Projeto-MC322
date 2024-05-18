package produtos;

import java.util.Scanner;
import enumeration.Tamanho;

public class Bebida extends ProdutoSimples {
    
    Tamanho tamanho;

    public Bebida()
    {
        this.tamanho = Tamanho.INDEFINIDO;
        this.preco = -1;
        this.nome = "INDEFINIDO";
    }

    @Override
    public double calcularPreco() {
        if(tamanho == Tamanho.PEQUENO){
            return 4;
        }else if(tamanho == Tamanho.MEDIO){
            return 8;
        }else if(tamanho == Tamanho.GRANDE){
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

    @Override
    public void definirOpcoes() {
        Scanner inputOpcao = new Scanner(System.in);
        System.out.println("Qual tamanho da bebida? (P) - Pequena, R$4,00; (M) - Media, R$8,00 (G) - Grande, R$12,00: ");
        String opcao = inputOpcao.next();
        switch (opcao){
            case "P":
                this.tamanho = Tamanho.PEQUENO;
            case "M":
                this.tamanho = Tamanho.MEDIO;
            case "G":
                this.tamanho = Tamanho.GRANDE;
        }
        inputOpcao.close();
    }

}