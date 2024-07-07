import javax.swing.*;

public class Interface extends JFrame {
    JFrame janela;
    JTextField campoNome, campoCPF;
    JLabel texto, textoNome, textoCPF;
    JButton botao;

    public Interface(String nome) {
        janela = new JFrame(nome);
        texto = new JLabel("Bem vindo(a)!");
        campoNome = new JTextField(10);
        textoNome = new JLabel("Nome: ");
        textoNome.setLabelFor(campoNome);
        campoCPF = new JTextField(10);
        textoCPF = new JLabel("CPF: ");
        textoCPF.setLabelFor(campoCPF);
        // ououou descobri como dá acesso a vc pelo terminal. tava readonly mudei pra read/write
        // agr ce consegue dar play e usar o git
        // eu creio
        // n sei como fica a parte da janela que abre...

    }
}