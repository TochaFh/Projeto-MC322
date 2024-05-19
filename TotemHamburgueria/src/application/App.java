package application;

import dados.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // 'DADOS' é um objeto que armazena as informações base, como o nome do
    // restaurante e o cardápio
    private static DadosApp DADOS;
    private static Scanner scan = new Scanner(System.in);

    public static DadosApp getDADOS() {
        return DADOS;
    }

    public static int readInt() {
        int x;

        try {
            x = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.print("O termo digitado não é um número válido! Digite novamente: ");
            x = readInt();
        }

        return x;
    }

    public static String readLine() {
        return scan.nextLine();
    }

    public static String readNext() {
        return scan.next();
    }

    public static Cliente cadastroCliente() {

        System.out.println("Informe seu nome:");
        String nome = scan.nextLine();
        System.out.println("Informe seu cpf:");
        String cpf = scan.nextLine();

        return new Cliente(nome, cpf);
    }

    public static void main(String[] args) throws Exception {

        // o banco de dados é a fonte dos dados da aplicação
        // no momento estamos usando uma implementação hardcoded,
        // mas pode ser mudado para uma que lê os dados de um arquivo, por exemplo
        BancoDeDados banco = new DadosHardcoded();
        DADOS = banco.obterDadosApp();

        System.out.println("\n--- " + DADOS.getNomeRestaurante() + " ---\nBem vindo(a)!");
        // Cadastro do cliente
        Cliente cliente = cadastroCliente();

        // Impressao do cardapio
        Carrinho cardapio = DADOS.getCardapio(); // temporario

        // Query editando o carrinho, com comandos de adicionar/remover produtos, ou
        // concluir

        Carrinho carrinho = new Carrinho();
        Pedido pedido = new Pedido(cliente, carrinho);

        System.out.println("-------------\nCARDÁPIO:\n" + cardapio + "-------------");

        boolean concluir = false;
        do {
            System.out.println(
                    " - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);");
            String comando = scan.next().toUpperCase();

            switch (comando) {
                case "A":
                    int idItem = readInt();
                    carrinho.adicionarProduto(cardapio.getProduto(idItem));
                    System.out.println("Item adicionado!");
                    break;
                // ** parte da definição de opções tá dentro do adicionar produto no carrinho!!!

                case "R":
                    int idItemRemovido = readInt();
                    System.out.println("Item removido! (" + carrinho.getProduto(idItemRemovido) + ")");
                    carrinho.removerProdutoPorId(idItemRemovido);
                    break;

                case "C":
                    concluir = true;
                    break;
                default:
                    System.out.println("Comando inválido, tente novamente.");
                    break;

            }
            System.out.println("===Carrinho===\n" + carrinho);
            System.out.println("Total: R$" + carrinho.calculaTotal());

        } while (!concluir);

        // Define se o pedido é para viagem
        System.out.println(" - O pedido é para viagem?(S/N): ");
        String opcaoViagem = scan.next();
        if (opcaoViagem.toUpperCase() == "S") {
            pedido.setParaViagem(true);
        } // else: Por padrão o pedido já não é para viagem

        // Simulação simples de pagamento
        System.out.println(" - Qual será a forma de pagamento? P (Pix) | D (Débito) | C (Crédito) | R (Refeição)");
        scan.next();
        System.out.println("Processando...");
        System.out.println("Pagamento realizado com sucesso!");

        // Impressão final do pedido
        System.out.println(pedido);
        System.out.println("Seu pedido foi enviado para cozinha, ele estará pronto em alguns instantes!");
        System.out.println("Obrigado pela preferência, " + cliente + "!");

        scan.close();
    }
}
