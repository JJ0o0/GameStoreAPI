package com.j0o0ll.gamestoreapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String produtora;
    private Integer estoque;
    private BigDecimal preco;
}
