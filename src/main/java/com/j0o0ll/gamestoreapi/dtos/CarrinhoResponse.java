package com.j0o0ll.gamestoreapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoResponse {
    private Long id;
    private Long cliente_id;
    private List<ItemCarrinhoResponse> itens;
}