package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import application.Pedido;


public class JanelaPagamento extends JFrame {

    private AppVisual appVisual;
    private String opcaoPagamento;

    JPanel panel;

    public JanelaPagamento(AppVisual appVisual) {
        this.appVisual = appVisual;
    }

    public void iniciar()
    {
        setTitle("Pagamento");
        setLayout(new BorderLayout(10, 5));

        setSize(400, 500);
        setLocation(800, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));

        JLabel totalCarrinho = new JLabel("Total: " + appVisual.getPedido().getCarrinho().calculaTotal());
        totalCarrinho.setForeground(new Color(0, 71, 2));
        panel.add(totalCarrinho);

        panel.add(new JLabel("Escolha a forma de pagamento: "));

        JButton bPix = new JButton("Pix");
        bPix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnOpcaoPagamentoClick("Pix");
            }
        });
        panel.add(bPix);

        JButton bCredito = new JButton("Crédito");
        bCredito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnOpcaoPagamentoClick("Crédito");
            }
        });
        panel.add(bCredito);

        JButton bDebito = new JButton("Débito");
        bDebito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnOpcaoPagamentoClick("Débito");
            }
        });
        panel.add(bDebito);

        JButton bRefeicao = new JButton("Refeição");
        bRefeicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnOpcaoPagamentoClick("Refeição");
            }
        });
        panel.add(bRefeicao);

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void OnOpcaoPagamentoClick(String opcao)
    {
        opcaoPagamento = opcao;

        panel.removeAll();

        JLabel sucesso = new JLabel("Sucesso!");
        sucesso.setForeground(new Color(0, 71, 2));
        panel.add(sucesso);

        panel.add(new JLabel("Pagamento efetuado - " + opcaoPagamento));

        JLabel cozinha = new JLabel("Seu pedido foi enviado para cozinha, ele estará pronto em alguns instantes!");
        cozinha.setForeground(new Color(179, 116, 0));
        panel.add(sucesso);

        Pedido pedido = appVisual.getPedido();

        panel.add(new JLabel("Obrigado pela preferência, " + pedido.getCliente() + "!"));

        JTextArea recibo = new JTextArea(pedido.toString());
        recibo.setColumns(21);
        recibo.setLineWrap(true);
        panel.add(recibo);

        JButton concluir = new JButton("Concluir");
        concluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnConcluirClick();
            }
        });
        panel.add(concluir);

        repaint();
        revalidate();
    }

    private void OnConcluirClick()
    {
        appVisual.pagamentoEfetuado();
    }
}
