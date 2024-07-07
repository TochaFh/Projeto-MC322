package visual;

import application.*;
import dados.*;

public class AppVisual {

    static void print(String a)
    {
        System.out.println(a);
    }

    private DadosApp dadosApp;
    private Pedido pedido;

    public AppVisual(DadosApp dadosApp)
    {
        this.dadosApp = dadosApp;
        pedido = new Pedido();
        pedido.setCarrinho(new Carrinho());
    }

    public DadosApp getDadosApp()
    {
        return dadosApp;
    }

    public Pedido getPedido()
    {
        return pedido;
    }

    public void iniciar()
    {
        mostrarCadastro();
        //mostrarCardapio(); // temporario para teste
    }

    private void mostrarCadastro()
    {
        CadastroCliente telaCadastro = new CadastroCliente(this);
        telaCadastro.iniciar();
    }

    protected void cadastroConcluido(Cliente cliente)
    {
        pedido.setCliente(cliente);
        mostrarCardapio();
    }

    private void mostrarCardapio()
    {
        JanelaCardapio janelaCardapio = new JanelaCardapio(this);
        janelaCardapio.iniciar();
    }

    protected void carrinhoMontado()
    {
        mostrarPagamento();
    }

    private void mostrarPagamento()
    {

    }
}
