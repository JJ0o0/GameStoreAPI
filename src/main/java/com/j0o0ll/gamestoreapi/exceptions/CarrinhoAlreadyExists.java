package com.j0o0ll.gamestoreapi.exceptions;

public class CarrinhoAlreadyExists extends RuntimeException {
    public CarrinhoAlreadyExists() {
        super("Carrinho já existe!");
    }

    public CarrinhoAlreadyExists(String clienteName) {
        super(String.format("Carrinho já existe para %s!", clienteName));
    }
}
