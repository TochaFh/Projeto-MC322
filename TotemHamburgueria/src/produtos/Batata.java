package produtos;

import enumeration.Tamanho;

public abstract class Batata extends ProdutoSimples {

    private Tamanho tamanho;
    
    @Override
    public double calcularPreco() {
        if(tamanho == Tamanho.PEQUENO){
            return 5;
        }else if(tamanho == Tamanho.MEDIO){
            return 10;
        }else if(tamanho == Tamanho.GRANDE){
            return 15;
        }
        return 0;
    }

    @Override
    public Produto clonarProduto(int novoId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean definirOpcoes() {
        // TODO Auto-generated method stub
        return false;
    }
}
