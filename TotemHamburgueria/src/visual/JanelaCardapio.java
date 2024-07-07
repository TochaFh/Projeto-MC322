package visual;

import application.*;
import dados.*;
import produtos.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCardapio extends JFrame {

    private AppVisual appVisual;
    private DadosApp dadosApp;

    private Carrinho carrinhoCliente;

    private JButton botaoAvancar;
    private JPanel areaCarrinho;
    private JLabel warning;

    public JanelaCardapio(AppVisual appVisual) {
        this.appVisual = appVisual;
        dadosApp = appVisual.getDadosApp();
        carrinhoCliente = appVisual.getPedido().getCarrinho();
    }

    public void iniciar()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle(dadosApp.getNomeRestaurante());
        setLayout(new BorderLayout(10, 5));

        setSize(1000, 600);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));


        // area cardapio
        JPanel areaCardapio = new JPanel();
        areaCardapio.setLayout(new BoxLayout(areaCardapio, BoxLayout.Y_AXIS));

        for (Produto produto : dadosApp.getCardapio().getProdutos()) {
            areaCardapio.add(new ItemCardapioPanel(produto, carrinhoCliente, this));
        }

        JScrollPane sp = new JScrollPane(areaCardapio);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        p.add(sp);


        // botao avançar
        botaoAvancar = new JButton("Avançar");
        botaoAvancar.setForeground(Color.WHITE);
        botaoAvancar.setBackground(new Color(0, 71, 2));
        botaoAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnAvancarClick(e);
            }
        });
        p.add(botaoAvancar);

        warning = new JLabel("  ");

        // area carrinho
        areaCarrinho = new JPanel();
        areaCarrinho.setLayout(new BoxLayout(areaCarrinho, BoxLayout.Y_AXIS));

        this.OnCarrinhoAtualizado();

        p.add(areaCarrinho);


        // warning
        warning.setForeground(Color.RED);
        p.add(warning);

        this.add(p, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void OnAvancarClick(ActionEvent e){

        if (carrinhoCliente.getSize() == 0)
        {
            warning.setText("*carrinho vazio");
            return;
        }
        appVisual.carrinhoMontado();
        setVisible(false);
    }

    public void OnCarrinhoAtualizado()
    {
        warning.setText("  ");

        areaCarrinho.removeAll();

        areaCarrinho.add(new JLabel("Carrinho:"));
        for (Produto produto : carrinhoCliente.getProdutos()) {
            areaCarrinho.add(new Label(produto.getNome()));
        }

        repaint();
        revalidate();
    }
}