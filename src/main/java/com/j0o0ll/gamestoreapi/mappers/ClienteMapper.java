package com.j0o0ll.gamestoreapi.mappers;

import com.j0o0ll.gamestoreapi.dtos.ClienteRequest;
import com.j0o0ll.gamestoreapi.dtos.ClienteResponse;
import com.j0o0ll.gamestoreapi.entities.Cliente;

public class ClienteMapper {
    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }

    public static Cliente toEntity(ClienteRequest request) {
        return new Cliente(
                null,
                request.getNome(),
                request.getEmail(),
                request.getSenha()
        );
    }
}
