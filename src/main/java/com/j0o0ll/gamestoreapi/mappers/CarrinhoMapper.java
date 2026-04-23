package com.j0o0ll.gamestoreapi.mappers;

import com.j0o0ll.gamestoreapi.dtos.CarrinhoResponse;
import com.j0o0ll.gamestoreapi.dtos.ItemCarrinhoResponse;
import com.j0o0ll.gamestoreapi.entities.Carrinho;

import java.util.List;

public class CarrinhoMapper {
    public static CarrinhoResponse toResponse(Carrinho carrinho) {
        List<ItemCarrinhoResponse> responses = carrinho.getItens()
                .stream()
                .map(ItemCarrinhoMapper::toResponse).toList();

        return new CarrinhoResponse(
                carrinho.getId(),
                carrinho.getCliente().getId(),
                responses
        );
    }
}
