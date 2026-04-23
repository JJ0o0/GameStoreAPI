package com.j0o0ll.gamestoreapi.services;

import com.j0o0ll.gamestoreapi.dtos.CarrinhoRequest;
import com.j0o0ll.gamestoreapi.dtos.CarrinhoResponse;
import com.j0o0ll.gamestoreapi.entities.Carrinho;
import com.j0o0ll.gamestoreapi.entities.Cliente;
import com.j0o0ll.gamestoreapi.entities.Produto;
import com.j0o0ll.gamestoreapi.exceptions.CarrinhoAlreadyExists;
import com.j0o0ll.gamestoreapi.exceptions.CarrinhoNotFound;
import com.j0o0ll.gamestoreapi.exceptions.ProdutoNotFound;
import com.j0o0ll.gamestoreapi.mappers.CarrinhoMapper;
import com.j0o0ll.gamestoreapi.repositories.CarrinhoRepository;
import com.j0o0ll.gamestoreapi.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Data
@Service
@AllArgsConstructor
public class CarrinhoService {
    private final CarrinhoRepository repository;
    private final ClienteService clienteService;

    public CarrinhoResponse criar(CarrinhoRequest request) {
        Cliente cliente = clienteService.buscarEntidadePorId(request.getCliente_id());

        Optional<Carrinho> existente = repository.findByClienteId(cliente.getId());
        if (existente.isPresent()) {
            throw new CarrinhoAlreadyExists(cliente.getNome());
        }

        Carrinho carrinho = new Carrinho();
        carrinho.setItens(new ArrayList<>());
        carrinho.setCliente(cliente);

        return CarrinhoMapper.toResponse(repository.save(carrinho));
    }

    public CarrinhoResponse buscarPorId(Long id) {
        return repository.findById(id)
                .map(CarrinhoMapper::toResponse)
                .orElseThrow(() -> new CarrinhoNotFound(id));
    }

    public CarrinhoResponse buscarPorClienteId(Long cliente_id) {
        return repository.findByClienteId(cliente_id)
                .map(CarrinhoMapper::toResponse)
                .orElseThrow(() -> new CarrinhoNotFound(cliente_id, true));
    }

    public Carrinho buscarEntidadePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CarrinhoNotFound(id));
    }
}
