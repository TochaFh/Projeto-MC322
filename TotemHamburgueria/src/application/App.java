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

        // * Para gerar o arquivo de dados binario default
        //DadosBinario.gerarArquivoDefault();
        //System.exit(0);

        // o banco de dados é a fonte dos dados da aplicação
        // aqui etsamos usando a implementação que lê de um arquivo binario
        BancoDeDados banco = new DadosBinario("dadosapp_default_binario");
        DADOS = banco.obterDadosApp();

        // as janelas do app são todas controladas pelo 'appVisual'
        AppVisual appVisual = new AppVisual(DADOS);
        appVisual.iniciar();

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
