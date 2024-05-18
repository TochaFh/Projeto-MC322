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
        Carrinho cardapio = new Carrinho(); //temporario

        // Query com comando de adicionar/remover produtos, ou concluir

        // provisório, n sei se vai fazer assim
        Carrinho carrinho = new Carrinho();

        Scanner input = new Scanner(System.in);
        
        boolean concluir = false;
        do {
            System.out.println(" - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);");
            String opcao = input.next();

            switch(opcao.charAt(0)){
                case 'A':
                    int idItem = Character.getNumericValue(opcao.charAt(2));
                    carrinho.adicionarProduto(cardapio.getProduto(idItem));
                    System.out.println("Item adicionado!");

                case 'R':
                    int idItemRemovido = Character.getNumericValue(opcao.charAt(2));
                    carrinho.removerProdutoPorId(idItemRemovido);
                    System.out.println("Item removido!");

                case 'C':
                    concluir = true;
            }
            System.out.println(carrinho);

        } while(!concluir); 

        // Define se o pedido é para viagem
        System.out.println(" - O pedido é para viagem?(S/N): ");
        String opcaoViagem = input.next();
        if(opcaoViagem.toUpperCase() == "S"){
            // TODO set pedido para viagem
        }else{
            // TODO set pedido para comer aqui
        }

        // Pagamento

        input.close();
    }
}
