package io.github.lipeacelino.agenda.api;

import io.github.lipeacelino.agenda.domain.entities.Cliente;
import io.github.lipeacelino.agenda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente getClienteById(@PathVariable Integer id){
        return clienteService.getClienteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCliente(@RequestBody Cliente c) {
        clienteService.addCliente(c);
    }

}
