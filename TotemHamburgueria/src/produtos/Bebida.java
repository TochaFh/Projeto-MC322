package produtos;

import enumeration.Tamanho;

public abstract class Bebida extends ProdutoSimples {
    
    Tamanho tamanho;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean definirOpcoes() {
        // TODO Auto-generated method stub
        return false;
    }

}