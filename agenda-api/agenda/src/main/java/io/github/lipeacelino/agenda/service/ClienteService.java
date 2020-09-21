package io.github.lipeacelino.agenda.service;

import io.github.lipeacelino.agenda.domain.entities.Cliente;
import io.github.lipeacelino.agenda.domain.repositories.ClienteRepository;
import io.github.lipeacelino.agenda.exception.ClienteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository rep;

    public void addCliente(Cliente c) {
        rep.save(c);
    }

    public Cliente getClienteById(Integer id) {
        ClienteNotFoundException rs = new ClienteNotFoundException("Cliente não encontrado.");
        return rep.findById(id).orElseThrow(() -> {return rs;});
    }

    public void deleteCliente(Integer id) {
        rep.delete(rep.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado.")));
    }

    public void updateCliente(Integer id, Cliente c) {
        rep.save(rep.findById(id)
                .map(clienteBd -> clienteBd.builder().nome(c.getNome()).cpf(c.getCpf()).build())
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado.")));
    }
}
