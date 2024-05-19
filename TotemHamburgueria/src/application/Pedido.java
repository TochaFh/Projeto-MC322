package application;

import dados.*;

public class Pedido {
    private Cliente cliente;
    private Carrinho carrinho;
    private boolean paraViagem;

    public Pedido(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        paraViagem = false;
    }

    @Override
    public String toString() {
        String out = "===Pedido===\n";
        out += carrinho;
        out += "Total: R$" + carrinho.calculaTotal() + "\n";
        if (paraViagem)
            out += "Pedido para viagem.\n";
        else
            out += "Pedido para comer aqui.\n";
        out += "Cliente: " + cliente + ".\n";
        return out;
    }

    // Getters and Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public boolean isParaViagem() {
        return paraViagem;
    }

    public void setParaViagem(boolean paraViagem) {
        this.paraViagem = paraViagem;
    }

}