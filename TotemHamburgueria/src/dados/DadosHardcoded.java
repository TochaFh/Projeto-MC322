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

        cardapio.adicionarProdutoDireto(
            new Hamburguer("Double bacon spicy",
                "Pão de batata, bacon, hamburguer, queijo, maionese, molho apimentado",
                20)
        );

        cardapio.adicionarProdutoDireto(
            new Hamburguer("Big Columbini",
                "Pão de batata, bacon, hamburguer, queijo, tomate, alface, molho especial",
                30)
        );

        cardapio.adicionarProdutoDireto(
            new Hamburguer("Double Australian",
                "Pão australiano, dois hamburgueres, duas fatias de queijo, cebola crispy, maionese verde",
                28)
        );

        ArrayList<ProdutoSimples> combo1 = new ArrayList<ProdutoSimples>();
        combo1.add(new Hamburguer("Double Australian",
                "Pão australiano, dois hamburgueres, duas fatias de queijo, cebola crispy, maionese verde",
                28));
        combo1.add(new Batata());
        combo1.add(new Bebida());
        cardapio.adicionarProdutoDireto(new Combo("Combo Australiano", combo1));

        ArrayList<ProdutoSimples> combo2 = new ArrayList<ProdutoSimples>();
        combo2.add(new Hamburguer("Big Columbini",
                "Pão de batata, bacon, hamburguer, queijo, tomate, alface, molho especial",
                30));
        combo2.add(new Batata());
        combo2.add(new Bebida());
        cardapio.adicionarProdutoDireto(new Combo("Combo Colombini", combo2));

        cardapio.adicionarProdutoDireto(new Batata());

        cardapio.adicionarProdutoDireto(new Bebida());

        //cardapio.atualizarIds(1); // Não precisa pq o carrinho já seta o id na ordem

        return new DadosApp(nomeRestaurante, cardapio, tiposDeBebida);
    }

}
