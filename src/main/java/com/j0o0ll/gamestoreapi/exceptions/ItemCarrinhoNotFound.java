package com.j0o0ll.gamestoreapi.exceptions;

public class ItemCarrinhoNotFound extends RuntimeException {
    public ItemCarrinhoNotFound(Long id) {
        super(String.format("Item do Carrinho com id \"%d\" não foi encontrado!", id));
    }
}
