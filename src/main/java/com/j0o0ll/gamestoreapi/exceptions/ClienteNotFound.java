package com.j0o0ll.gamestoreapi.exceptions;

public class ClienteNotFound extends RuntimeException {
    public ClienteNotFound(Long id) {
        super(String.format("Cliente com id \"%d\" não foi encontrado.", id));
    }
}
