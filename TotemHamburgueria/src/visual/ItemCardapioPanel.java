package visual;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;

import dados.Carrinho;
import produtos.Produto;

public class ItemCardapioPanel extends JPanel {

    static Locale ptBr = new Locale("pt", "BR");

    private Produto produto;
    private Carrinho carrinhoCliente;
    private JanelaCardapio janelaCardapio;

    public ItemCardapioPanel(Produto produto, Carrinho carrinhoCliente, JanelaCardapio janelaCardapio)
    {
        this.produto = produto;
        this.carrinhoCliente = carrinhoCliente;
        this.janelaCardapio = janelaCardapio;

        setLayout(new FlowLayout());

        JLabel nome = new JLabel(produto.toString());
        nome.setForeground(new Color(179, 116, 0));
        add(nome);

        String d = produto.getDescricao();
        if (d != null && !d.isBlank())
        {
            JLabel descricao = new JLabel(" - " + produto.getDescricao());
            descricao.setForeground(Color.GRAY);
            add(descricao);
        }
        
        double valorPreco = produto.calcularPreco();

        if (valorPreco > 0)
        {
            String valorFormatado = NumberFormat.getCurrencyInstance(ptBr).format(valorPreco);

            JLabel preco = new JLabel(" - " + valorFormatado);
            preco.setForeground(new Color(0, 71, 2));
            add(preco);
        }

        JButton botaoAdicionar = new JButton(" + ");
        botaoAdicionar.setForeground(Color.WHITE);
        botaoAdicionar.setBackground(new Color(0, 71, 2));
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnAdicionarClick(e);
            }
        });
        add(botaoAdicionar);
    }

    private void OnAdicionarClick(ActionEvent e) {
        carrinhoCliente.adicionarProduto(produto);
        janelaCardapio.OnCarrinhoAtualizado();
    }
}
