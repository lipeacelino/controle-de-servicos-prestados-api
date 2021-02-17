package io.github.lipeacelino.agenda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.lipeacelino.agenda.domain.dto.ServicoPrestadoDTO;
import io.github.lipeacelino.agenda.domain.entities.ServicoPrestado;
import io.github.lipeacelino.agenda.service.ServicoPrestadoService;

@RestController
@RequestMapping("/api/servicos-prestados")
@ResponseStatus(HttpStatus.CREATED)
public class ServicoPrestadoController {
	
	@Autowired
	private ServicoPrestadoService service;
	
	@PostMapping
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		return service.salvar(dto);
	}
	
}
