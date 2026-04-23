package com.j0o0ll.gamestoreapi.mappers;

import com.j0o0ll.gamestoreapi.dtos.ItemCarrinhoRequest;
import com.j0o0ll.gamestoreapi.dtos.ItemCarrinhoResponse;
import com.j0o0ll.gamestoreapi.entities.Carrinho;
import com.j0o0ll.gamestoreapi.entities.ItemCarrinho;
import com.j0o0ll.gamestoreapi.entities.Produto;

public class ItemCarrinhoMapper {
    public static ItemCarrinhoResponse toResponse(ItemCarrinho itemCarrinho) {
        return new ItemCarrinhoResponse(
                itemCarrinho.getId(),
                itemCarrinho.getCarrinho().getId(),
                itemCarrinho.getProduto().getId(),
                itemCarrinho.getQuantidade()
        );
    }

    public static ItemCarrinho toEntity(ItemCarrinhoRequest request, Carrinho carrinho, Produto produto) {
        return new ItemCarrinho(
                null,
                carrinho,
                produto,
                request.getQuantidade()
        );
    }
}