package visual;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;
import dados.Carrinho;
import produtos.Produto;

public class ItemNoCarrinhoPanel extends JPanel {

    private Produto produto;
    private Carrinho carrinhoCliente;
    private JanelaCardapio janelaCardapio;

    public ItemNoCarrinhoPanel(Produto produto, Carrinho carrinhoCliente, JanelaCardapio janelaCardapio)
    {
        this.produto = produto;
        this.carrinhoCliente = carrinhoCliente;
        this.janelaCardapio = janelaCardapio;

        setLayout(new FlowLayout());

        JLabel nome = new JLabel(produto.toString());
        nome.setForeground(new Color(0, 45, 143));
        add(nome);


        double valorPreco = produto.calcularPreco();
        if (valorPreco > 0)
        {
            String valorFormatado = NumberFormat.getCurrencyInstance(ItemCardapioPanel.ptBr).format(valorPreco);

            JLabel preco = new JLabel("  " + valorFormatado);
            preco.setForeground(new Color(107, 0, 5));
            add(preco);
        }


        JButton botaoRemover = new JButton(" - ");
        botaoRemover.setForeground(Color.WHITE);
        botaoRemover.setBackground(new Color(107, 0, 5));
        botaoRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnRemoverClick(e);
            }
        });
        add(botaoRemover);
    }

    private void OnRemoverClick(ActionEvent e) {
        carrinhoCliente.removerProduto(produto);
        janelaCardapio.OnCarrinhoAtualizado();
    }
}
