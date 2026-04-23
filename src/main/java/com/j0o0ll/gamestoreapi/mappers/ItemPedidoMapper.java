package com.j0o0ll.gamestoreapi.mappers;

import com.j0o0ll.gamestoreapi.dtos.ItemPedidoResponse;
import com.j0o0ll.gamestoreapi.entities.ItemPedido;

public class ItemPedidoMapper {
    public static ItemPedidoResponse toResponse(ItemPedido itemPedido) {
        return new ItemPedidoResponse(
                itemPedido.getId(),
                itemPedido.getPedido().getId(),
                itemPedido.getProduto().getId(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario()
        );
    }
}