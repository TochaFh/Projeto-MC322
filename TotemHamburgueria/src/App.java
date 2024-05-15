import produtos.*;
import java.util.Scanner;

public class App {

    public static Cliente cadastroCliente(){

        Scanner input = new Scanner(System.in);

        System.out.println("Informe seu nome:");
        String nome = input.next();
        System.out.println("Informe seu cpf:");
        String cpf = input.next();

        input.close();
        return new Cliente(nome, cpf);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! HAMBURGUERIA!");
        //Cadastro do cliente
        Cliente cliente = cadastroCliente();
        
        // Impressao do cardapio
        // Query com comando de adicionar/remover produtos, ou concluir
    }
}
