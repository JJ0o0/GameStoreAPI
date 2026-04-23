package com.j0o0ll.gamestoreapi.dtos;

import com.j0o0ll.gamestoreapi.enums.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {
    private Long id;
    private Long cliente_id;
    private List<ItemPedidoResponse> itens;
    private LocalDateTime dataPedido;
    private BigDecimal total;
    private PedidoStatus status;
}
