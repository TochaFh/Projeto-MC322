package dados;

import java.io.Serializable;

// CLasse para centralizar os dados base do sistema
public class DadosApp implements Serializable {
    
    private String nomeRestaurante;
    private Carrinho cardapio;
    private String[] tiposDeBebida;

    public DadosApp()
    {
        
    }

    public DadosApp(String nomeRestaurante, Carrinho cardapio, String[] tiposDeBebida)
    {
        this.nomeRestaurante = nomeRestaurante;
        this.cardapio = cardapio;
        this.tiposDeBebida = tiposDeBebida;
    }

    // Getters
    public String getNomeRestaurante() {
        return nomeRestaurante;
    }
    public Carrinho getCardapio() {
        return cardapio;
    }
    public String[] getTiposDeBebida() {
        return tiposDeBebida;
    }
}
