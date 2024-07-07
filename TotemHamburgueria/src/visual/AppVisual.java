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
    private Cliente cliente;

    public AppVisual(DadosApp dadosApp)
    {
        this.dadosApp = dadosApp;
    }

    public void iniciar()
    {
        CadastroCliente telaCadastro = new CadastroCliente(this);
        telaCadastro.iniciar();
    }

    protected void cadastroConcluido(Cliente cliente)
    {
        this.cliente = cliente;
        print(cliente.getNome() + cliente.getCpf());
        mostrarCardapio();
    }

    private void mostrarCardapio()
    {
        // TODO: tela de cardápio / montagem de carrinho
    }
}
