package com.j0o0ll.gamestoreapi.services;

import com.j0o0ll.gamestoreapi.dtos.ClienteRequest;
import com.j0o0ll.gamestoreapi.dtos.ClienteResponse;
import com.j0o0ll.gamestoreapi.entities.Cliente;
import com.j0o0ll.gamestoreapi.exceptions.ClienteNotFound;
import com.j0o0ll.gamestoreapi.exceptions.ProdutoNotFound;
import com.j0o0ll.gamestoreapi.mappers.ClienteMapper;
import com.j0o0ll.gamestoreapi.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteResponse criar(ClienteRequest request) {
        Cliente cliente = ClienteMapper.toEntity(request);

        return ClienteMapper.toResponse(repository.save(cliente));
    }

    public ClienteResponse editar(Long id, ClienteRequest request) {
        Cliente cliente = buscarEntidadePorId(id);
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setSenha(request.getSenha());

        return ClienteMapper.toResponse(repository.save(cliente));
    }

    public void deletar(Long id) {
        Cliente cliente = buscarEntidadePorId(id);

        repository.delete(cliente);
    }

    public List<ClienteResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ClienteMapper::toResponse)
                .toList();
    }

    public ClienteResponse buscarPorId(Long id) {
        return repository.findById(id)
                .map(ClienteMapper::toResponse)
                .orElseThrow(() -> new ClienteNotFound(id));
    }

    public Cliente buscarEntidadePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClienteNotFound(id));
    }
}
