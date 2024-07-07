package visual;

import application.*;
import dados.*;

public class AppVisual {

    private DadosApp dadosApp;
    private Pedido pedido;
    private Cliente cliente;

    public AppVisual(DadosApp dadosApp)
    {
        this.dadosApp = dadosApp;
    }

    public void iniciar()
    {
        new CadastroCliente("aaa");
    }
}
