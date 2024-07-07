package visual;

import application.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCliente extends JFrame {

    private AppVisual appVisual;

    private JTextField campoNome, campoCPF;
    private JButton botaoConfirmar;
    private JLabel warning;

    public CadastroCliente(AppVisual appVisual) {
        this.appVisual = appVisual;
    }

    public void OnConfirmarClick(ActionEvent e){

        String nome = campoNome.getText();
        String cpf = campoCPF.getText();

        if (nome == null | nome.isEmpty())
        {
            warning.setText("*Campo do nome vazio");
            return;
        }

        if (!App.validarCpf(cpf))
        {
            warning.setText("*CPF inválido");
            return;
        }

        setVisible(false);
        Cliente c = new Cliente(nome, cpf);
        appVisual.cadastroConcluido(c);
    }

    public void iniciar()
    {
        setTitle("Cadastro cliente");
        setLayout(new BorderLayout(10, 5));

        setSize(400, 250);
        setLocation(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));

        botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OnConfirmarClick(e);
            }
        });

        p.add(new JLabel("Bem vindo(a)!"));

        p.add(new JLabel("Nome: "));
        campoNome = new JTextField(10);
        p.add(campoNome);

        p.add(new JLabel("CPF: "));
        campoCPF = new JTextField(10);
        p.add(campoCPF);

        warning = new JLabel("  ");
        warning.setForeground(Color.RED);
        p.add(warning);

        p.add(botaoConfirmar);

        this.add(p, BorderLayout.CENTER);
        this.setVisible(true);
    }
}