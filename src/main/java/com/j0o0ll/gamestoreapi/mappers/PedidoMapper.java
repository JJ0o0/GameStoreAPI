package com.j0o0ll.gamestoreapi.mappers;

import com.j0o0ll.gamestoreapi.dtos.ItemPedidoResponse;
import com.j0o0ll.gamestoreapi.dtos.PedidoRequest;
import com.j0o0ll.gamestoreapi.dtos.PedidoResponse;
import com.j0o0ll.gamestoreapi.entities.Carrinho;
import com.j0o0ll.gamestoreapi.entities.Cliente;
import com.j0o0ll.gamestoreapi.entities.Pedido;
import com.j0o0ll.gamestoreapi.enums.PedidoStatus;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoMapper {
    public static PedidoResponse toResponse(Pedido pedido) {
        List<ItemPedidoResponse> responses = pedido.getItens()
                .stream()
                .map(ItemPedidoMapper::toResponse)
                .toList();

        return new PedidoResponse(
                pedido.getId(),
                pedido.getCliente().getId(),
                responses,
                pedido.getDataPedido(),
                pedido.getTotal(),
                pedido.getStatus()
        );
    }

    public static Pedido toEntity(PedidoRequest request, Cliente cliente, Carrinho carrinho) {
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(PedidoStatus.AGUARDANDO);

        return pedido;
    }
}
