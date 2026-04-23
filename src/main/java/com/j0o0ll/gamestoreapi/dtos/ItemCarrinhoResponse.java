package com.j0o0ll.gamestoreapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoResponse {
    private Long id;
    private Long carrinho_id;
    private Long produto_id;
    private Integer quantidade;
}
