package dados;

import produtos.*;
import java.util.ArrayList;

public class DadosHardcoded extends BancoDeDados {

    @Override
    public DadosApp obterDadosApp() {

        String nomeRestaurante = "Hamburgueria Daboa";

        String[] tiposDeBebida = {
            "Coca-cola",
            "Coca-cola zero",
            "Guaraná",
            "Guaraná zero",
            "Sprite",
            "Suco de laranja",
            "Suco de uva",
            "Suco de limão"
        };

        Carrinho cardapio = new Carrinho();

        // 1
        cardapio.adicionarProdutoDireto(
            new Hamburguer("Double bacon spicy",
                "Pão de batata, bacon, hamburguer, queijo, maionese, molho apimentado",
                20)
        );

        // 2
        cardapio.adicionarProdutoDireto(
            new Hamburguer("Big Columbini",
                "Pão de batata, bacon, hamburguer, queijo, tomate, alface, molho especial",
                30)
        );

        // 3
        cardapio.adicionarProdutoDireto(
            new Hamburguer("Double Australian",
                "Pão australiano, dois hamburgueres, duas fatias de queijo, cebola crispy, maionese verde",
                28)
        );

        // 4
        ArrayList<ProdutoSimples> combo1 = new ArrayList<ProdutoSimples>();
        combo1.add(new Hamburguer("Double Australian",
                "Pão australiano, dois hamburgueres, duas fatias de queijo, cebola crispy, maionese verde",
                28));
        combo1.add(new Batata());
        combo1.add(new Bebida());
        cardapio.adicionarProdutoDireto(new Combo("Combo Australiano", combo1));

        // 5
        ArrayList<ProdutoSimples> combo2 = new ArrayList<ProdutoSimples>();
        combo2.add(new Hamburguer("Big Columbini",
                "Pão de batata, bacon, hamburguer, queijo, tomate, alface, molho especial",
                30));
        combo2.add(new Batata());
        combo2.add(new Bebida());
        cardapio.adicionarProdutoDireto(new Combo("Combo Colombini", combo2));

        // 6
        ArrayList<ProdutoSimples> combo3 = new ArrayList<ProdutoSimples>();
        combo3.add(new Batata());
        combo3.add(new Batata());
        combo3.add(new Bebida());
        combo3.add(new Bebida());
        cardapio.adicionarProdutoDireto(new Combo("Batata + bebida em dobro", combo3));

        // 7
        cardapio.adicionarProdutoDireto(
            new Sobremesa("Brownie", "Delicioso brownie de chocolate!", 8)
        );

        // 8
        cardapio.adicionarProdutoDireto(new Batata());
        
        // 9
        cardapio.adicionarProdutoDireto(new Bebida());

        return new DadosApp(nomeRestaurante, cardapio, tiposDeBebida);
    }

}
