package com.j0o0ll.gamestoreapi.repositories;

import com.j0o0ll.gamestoreapi.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
