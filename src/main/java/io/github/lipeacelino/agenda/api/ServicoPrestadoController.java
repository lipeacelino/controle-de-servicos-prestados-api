package io.github.lipeacelino.agenda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.lipeacelino.agenda.domain.dto.ServicoPrestadoDTO;
import io.github.lipeacelino.agenda.domain.entities.ServicoPrestado;
import io.github.lipeacelino.agenda.service.ServicoPrestadoService;

@RestController
@RequestMapping("/api/servicos-prestados")
@CrossOrigin("http://localhost:4200")
public class ServicoPrestadoController {
	
	@Autowired
	private ServicoPrestadoService service;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		return service.salvar(dto);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<ServicoPrestado> pesquisarServico(
			@RequestParam(value = "nome", required = false, defaultValue = "") String nome, 
			@RequestParam(value = "mes", required = false) Integer mes ) {
		System.out.println(nome + mes);
		return service.pesquisarServico(nome, mes);
	}
}
