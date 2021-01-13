package io.github.lipeacelino.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.lipeacelino.agenda.domain.entities.Cliente;
import io.github.lipeacelino.agenda.domain.repositories.ClienteRepository;
import io.github.lipeacelino.agenda.exception.ClienteNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository rep;

    public Cliente addCliente(Cliente c) {
        return rep.save(c);
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
       rep.save(rep.findById(id).map(clienteBd -> {
    	   clienteBd.setNome(c.getNome());
    	   clienteBd.setCpf(c.getCpf());
    	   return clienteBd;
       }).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado.")));
    }

	public List<Cliente> getClientes() {
		return rep.findAll();
	}
    
}
