package com.j0o0ll.gamestoreapi.services;

import com.j0o0ll.gamestoreapi.dtos.ProdutoRequest;
import com.j0o0ll.gamestoreapi.dtos.ProdutoResponse;
import com.j0o0ll.gamestoreapi.entities.Produto;
import com.j0o0ll.gamestoreapi.exceptions.ProdutoNotFound;
import com.j0o0ll.gamestoreapi.mappers.ProdutoMapper;
import com.j0o0ll.gamestoreapi.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoResponse criar(ProdutoRequest request) {
        Produto produto = ProdutoMapper.toEntity(request);

        return ProdutoMapper.toResponse(repository.save(produto));
    }

    public ProdutoResponse editar(Long id, ProdutoRequest request) {
        Produto produto = buscarEntidadePorId(id);
        produto.setTitulo(request.getTitulo());
        produto.setDescricao(request.getDescricao());
        produto.setProdutora(request.getProdutora());
        produto.setPreco(request.getPreco());
        produto.setEstoque(request.getEstoque());

        return ProdutoMapper.toResponse(repository.save(produto));
    }

    public void deletar(Long id) {
        Produto produto = buscarEntidadePorId(id);

        repository.delete(produto);
    }

    public List<ProdutoResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProdutoMapper::toResponse)
                .toList();
    }

    public ProdutoResponse buscarPorId(Long id) {
        return repository.findById(id)
                .map(ProdutoMapper::toResponse)
                .orElseThrow(() -> new ProdutoNotFound(id));
    }

    public Produto buscarEntidadePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFound(id));
    }
}