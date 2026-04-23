package com.j0o0ll.gamestoreapi.repositories;

import com.j0o0ll.gamestoreapi.entities.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
    Optional<ItemCarrinho> findByCarrinhoIdAndProdutoId(Long carrinho_id, Long produto_id);
}