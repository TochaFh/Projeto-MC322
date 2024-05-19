package produtos;

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

    // Define o tamanho e o tipo de bebida escolhido pelo cliente
    @Override
    public void definirOpcoes() {
        System.out.println(
                "Qual o tamanho da bebida? (P) - Pequena, R$4,00; (M) - Media, R$8,00 (G) - Grande, R$12,00: ");
        String tam = "";

        String opcao;
        boolean opcaoInvalida;
        do {
            opcaoInvalida = false;
            opcao = App.readNext().toUpperCase();
            switch (opcao) {
                case "P":
                    this.tamanho = Tamanho.PEQUENO;
                    tam = "pequeno(a)";
                    break;
                case "M":
                    this.tamanho = Tamanho.MEDIO;
                    tam = "médio(a)";
                    break;
                case "G":
                    this.tamanho = Tamanho.GRANDE;
                    tam = "grande";
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente:");
                    opcaoInvalida = true;
                    break;
            }
        } while (opcaoInvalida);

        System.out.println("Qual o tipo da bebida?");

        String[] tiposBebida = App.getDADOS().getTiposDeBebida();

        for (int i = 0; i < tiposBebida.length; i++) {
            System.out.println((i + 1) + " - " + tiposBebida[i]);
        }

        int inputTipo = App.readInt();
        this.nome = tiposBebida[inputTipo - 1] + " " + tam;
    }
}