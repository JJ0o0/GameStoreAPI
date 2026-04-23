package com.j0o0ll.gamestoreapi.exceptions;

public class InsufficientStock extends RuntimeException {
    public InsufficientStock(Long item_id) {
        super(String.format("Estoque insuficiente para \"%d\"", item_id));
    }

    public InsufficientStock(Long item_id, Integer estoque_disponivel) {
      super(String.format("Estoque insuficiente para \"%d\".%nEstoque Disponivel: %d", item_id, estoque_disponivel));
    }
}
