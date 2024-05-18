import produtos.Batata;
import produtos.Bebida;
import produtos.Hamburguer;

public class DadosHardcoded extends BancoDeDados {

    @Override
    public DadosApp obterDadosApp() {

        String[] tiposDeBebida = {
            "INDEFINIDO",
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

        cardapio.adicionarProduto(
            new Hamburguer("Double bacon spicy",
                "Pão de batata, bacon, hamburguer, queijo, maionese, molho apimentado",
                20)
        );

        cardapio.adicionarProduto(
            new Hamburguer("",
                "",
                20)
        );

        cardapio.adicionarProduto(
            new Hamburguer("",
                "",
                20)
        );

        cardapio.adicionarProduto(new Batata());

        cardapio.adicionarProduto(new Bebida());

        cardapio.atualizarIds(0);

        return new DadosApp(cardapio, tiposDeBebida);
    }

}
