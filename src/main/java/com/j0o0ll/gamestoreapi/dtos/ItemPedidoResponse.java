package com.j0o0ll.gamestoreapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoResponse {
    private Long id;
    private Long pedido_id;
    private Long produto_id;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}