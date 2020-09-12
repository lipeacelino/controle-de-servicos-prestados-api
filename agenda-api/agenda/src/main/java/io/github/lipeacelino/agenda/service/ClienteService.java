package io.github.lipeacelino.agenda.service;

import io.github.lipeacelino.agenda.domain.entities.Cliente;
import io.github.lipeacelino.agenda.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository rep;

    public void addCliente(Cliente c) {
        rep.save(c);
    }

    public Cliente getClienteById(Integer id) {
        return rep.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
