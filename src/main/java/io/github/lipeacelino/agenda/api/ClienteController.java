package io.github.lipeacelino.agenda.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.lipeacelino.agenda.domain.entities.Cliente;
import io.github.lipeacelino.agenda.service.ClienteService;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {
	
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente getClienteById(@PathVariable Integer id) {
        return clienteService.getClienteById(id);
    }
    
    @GetMapping
    public List<Cliente> getClientes() {
		return clienteService.getClientes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente addCliente(@Valid @RequestBody Cliente c) { return clienteService.addCliente(c); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCliente(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@Valid @PathVariable Integer id, @RequestParam Cliente c) {
        clienteService.updateCliente(id, c);
    }
    
}
