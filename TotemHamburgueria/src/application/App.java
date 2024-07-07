package application;

import dados.*;
import visual.AppVisual;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // 'DADOS' é um objeto que armazena as informações base, como o nome do
    // restaurante e o cardápio
    private static DadosApp DADOS;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        //DadosBinario.gerarArquivoDefault();
        //System.exit(0);

        // o banco de dados é a fonte dos dados da aplicação
        BancoDeDados banco = new DadosBinario("dadosapp_default_binario");
        DADOS = banco.obterDadosApp();

        AppVisual appVisual = new AppVisual(DADOS);
        appVisual.iniciar();

        /*System.out.println("\n--- " + DADOS.getNomeRestaurante() + " ---\nBem vindo(a)!");
        
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
                    if (idItem > cardapio.getSize() || idItem < 1)
                    {
                        System.out.println("Indice inválido, tente novamente!");
                    }
                    else
                    {
                        carrinho.adicionarProduto(cardapio.getProduto(idItem));
                        System.out.println("Item adicionado!");
                    }
                    
                    break;
                // ** parte da definição de opções tá dentro do adicionar produto no carrinho!!!

                case "R":
                    int idItemRemovido = readInt();
                    if (idItemRemovido > carrinho.getSize() || idItemRemovido < 1)
                    {
                        System.out.println("Indice inválido, tente novamente!");
                    }
                    else
                    {
                        System.out.println("Item removido! (" + carrinho.getProduto(idItemRemovido) + ")");
                        carrinho.removerProdutoPorId(idItemRemovido);
                    }
                    break;

                case "C":
                    concluir = true;
                    break;
                default:
                    System.out.println("Comando inválido, tente novamente.");
                    break;

            }
            System.out.println("\n\n===Carrinho===\n" + carrinho);
            System.out.println("Total: " + carrinho.calculaTotal());

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
        */
        scan.close();
    }

    public static DadosApp getDADOS() {
        return DADOS;
    }

    // Método para ler inteiros do console
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

    public static boolean validarCpf(String cpf) {
        String digitos = cpf.replaceAll("[.-]", "");

        // se o número de dígitos é diferente de 11
        if (digitos.length() != 11)
            return false;

        // se todos os dígitos são iguais
        if (numerosTodosIguaisCpf(digitos))
            return false;

        // transformando o cpf numa array de ints
        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            numeros[i] = Integer.parseInt(String.valueOf(digitos.charAt(i)));
        }

        // cálculo dos dígitos verificadores
        int primeiroDV = calcularDV(numeros, 0);
        int segundoDV = calcularDV(numeros, 1);

        return primeiroDV == numeros[9] && segundoDV == numeros[10];
    }

    // auxiliar - diz se os dígitos do cpf são todos o mesmo
    private static boolean numerosTodosIguaisCpf(String digitos) {
        for (int i = 1; i < 11; i++) {
            if (digitos.charAt(0) != digitos.charAt(i))
                return false;
        }

        return true;
    }

    // auxiliar - calcula o DV (dígito verificador) considerando os 9 numeros a
    // partir do index start
    private static int calcularDV(int[] numeros, int start) {
        int soma = 0;

        // na prática, o start é quantas posições a frente de i=0 começa
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * numeros[i + start];
        }

        int resto = soma % 11;
        int dv = (resto <= 1) ? 0 : 11 - resto;

        return dv;
    }

    // Recebe os dados e constroi o Cliente
    public static Cliente cadastroCliente() {

        System.out.println("Informe seu nome:");
        String nome = scan.nextLine();

        System.out.println("Informe seu cpf:");
        String cpf = scan.nextLine();
        
        while (!validarCpf(cpf)) {
            System.out.println("Cpf inválido, digite novamente:");
            cpf = scan.nextLine();    
        }

        return new Cliente(nome, cpf);
    }
}
