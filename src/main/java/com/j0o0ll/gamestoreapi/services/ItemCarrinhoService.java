package com.j0o0ll.gamestoreapi.services;

import com.j0o0ll.gamestoreapi.dtos.ItemCarrinhoRequest;
import com.j0o0ll.gamestoreapi.dtos.ItemCarrinhoResponse;
import com.j0o0ll.gamestoreapi.entities.Carrinho;
import com.j0o0ll.gamestoreapi.entities.ItemCarrinho;
import com.j0o0ll.gamestoreapi.entities.Produto;
import com.j0o0ll.gamestoreapi.exceptions.InsufficientStock;
import com.j0o0ll.gamestoreapi.exceptions.ItemCarrinhoNotFound;
import com.j0o0ll.gamestoreapi.mappers.ItemCarrinhoMapper;
import com.j0o0ll.gamestoreapi.repositories.ItemCarrinhoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
@AllArgsConstructor
public class ItemCarrinhoService {
    private final ItemCarrinhoRepository repository;
    private final ProdutoService produtoService;
    private final CarrinhoService carrinhoService;

    public ItemCarrinhoResponse adicionar(ItemCarrinhoRequest request) {
        Carrinho carrinho = carrinhoService.buscarEntidadePorId(request.getCarrinho_id());
        Produto produto = produtoService.buscarEntidadePorId(request.getProduto_id());

        if (produto.getEstoque() < request.getQuantidade()) {
            throw new InsufficientStock(produto.getId(), produto.getEstoque());
        }

        Optional<ItemCarrinho> itemExistente = repository.findByCarrinhoIdAndProdutoId(carrinho.getId(), produto.getId());
        if (itemExistente.isPresent()) {
            ItemCarrinho itemExistenteEntidade = itemExistente.get();
            itemExistenteEntidade.setQuantidade(
                    itemExistenteEntidade.getQuantidade() + request.getQuantidade()
            );

            if (produto.getEstoque() < itemExistenteEntidade.getQuantidade()) {
                throw new InsufficientStock(produto.getId(), produto.getEstoque());
            }

            return ItemCarrinhoMapper.toResponse(repository.save(itemExistenteEntidade));
        }

        ItemCarrinho item = ItemCarrinhoMapper.toEntity(request, carrinho, produto);

        return ItemCarrinhoMapper.toResponse(repository.save(item));
    }

    public void deletar(Long id) {
        ItemCarrinho item = buscarEntidadePorId(id);

        repository.delete(item);
    }

    public List<ItemCarrinhoResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ItemCarrinhoMapper::toResponse)
                .toList();
    }

    public ItemCarrinhoResponse buscarPorId(Long id) {
        return repository.findById(id)
                .map(ItemCarrinhoMapper::toResponse)
                .orElseThrow(() -> new ItemCarrinhoNotFound(id));
    }

    private ItemCarrinho buscarEntidadePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemCarrinhoNotFound(id));
    }
}
