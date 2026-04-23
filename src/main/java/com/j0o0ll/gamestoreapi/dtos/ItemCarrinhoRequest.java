package com.j0o0ll.gamestoreapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoRequest {
    @NotNull
    private Long carrinho_id;

    @NotNull
    private Long produto_id;

    @NotNull
    @Positive
    private Integer quantidade;
}
