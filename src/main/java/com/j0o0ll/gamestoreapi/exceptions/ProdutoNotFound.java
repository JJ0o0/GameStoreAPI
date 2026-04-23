package com.j0o0ll.gamestoreapi.exceptions;

public class ProdutoNotFound extends RuntimeException {
    public ProdutoNotFound(Long id) {
        super(String.format("Produto com id \"%d\" não foi encontrado.", id));
    }
}
