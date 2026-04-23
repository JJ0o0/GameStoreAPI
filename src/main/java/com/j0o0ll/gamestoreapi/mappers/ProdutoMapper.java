package com.j0o0ll.gamestoreapi.mappers;

import com.j0o0ll.gamestoreapi.dtos.ProdutoRequest;
import com.j0o0ll.gamestoreapi.dtos.ProdutoResponse;
import com.j0o0ll.gamestoreapi.entities.Produto;

public class ProdutoMapper {
    public static ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getTitulo(), produto.getDescricao(),
                produto.getProdutora(),
                produto.getEstoque(),
                produto.getPreco()
        );
    }

    public static Produto toEntity(ProdutoRequest request) {
        return new Produto(
                null,
                request.getTitulo(), request.getDescricao(),
                request.getProdutora(),
                request.getEstoque(), request.getPreco()
        );
    }
}
