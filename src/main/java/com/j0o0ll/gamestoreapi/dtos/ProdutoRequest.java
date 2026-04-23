package com.j0o0ll.gamestoreapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String produtora;

    @NotNull
    @PositiveOrZero
    private Integer estoque;

    @NotNull
    @Positive
    private BigDecimal preco;
}