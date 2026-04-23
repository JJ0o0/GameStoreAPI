package com.j0o0ll.gamestoreapi.repositories;

import com.j0o0ll.gamestoreapi.entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> { }