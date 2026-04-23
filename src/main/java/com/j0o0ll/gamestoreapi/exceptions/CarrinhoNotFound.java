package com.j0o0ll.gamestoreapi.exceptions;

public class CarrinhoNotFound extends RuntimeException {
    public CarrinhoNotFound(Long id) {
        super(String.format("Carrinho com id \"%d\" não foi encontrado!", id));
    }

  public CarrinhoNotFound(Long cliente_id, boolean user) {
    super(String.format("Carrinho do cliente com id \"%d\" não foi encontrado!", cliente_id));
  }
}
