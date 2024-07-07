package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCliente extends JFrame {
    //JFrame janela;
    JTextField campoNome, campoCPF;
    JButton botaoConfirmar;

    public CadastroCliente(String nome) {
        iniciar();
    }

    public void OnConfirmarClick(ActionEvent e){
        // TODO: mandar dados do cliente pro AppVisual e passar para a próxima janela
    }

    private void iniciar()
    {
        setTitle("Cadastro cliente");
        setLayout(new BorderLayout(10, 5));

        setSize(200, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

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

        p.add(botaoConfirmar);

        this.add(p, BorderLayout.CENTER);
        this.setVisible(rootPaneCheckingEnabled);
    }
}