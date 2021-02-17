package io.github.lipeacelino.agenda.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.lipeacelino.agenda.domain.dto.ServicoPrestadoDTO;
import io.github.lipeacelino.agenda.domain.entities.Cliente;
import io.github.lipeacelino.agenda.domain.entities.ServicoPrestado;
import io.github.lipeacelino.agenda.domain.repositories.ServicoPrestadoRepository;

@Service
public class ServicoPrestadoService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicoPrestadoRepository repository;

	public ServicoPrestado salvar(ServicoPrestadoDTO dto) {
		
		Cliente cliente = clienteService.getClienteById(dto.getIdCliente());
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		ServicoPrestado servicoPrestado = ServicoPrestado.builder()
				.cliente(cliente)
				.data(data)
				.descricao(dto.getDescricao())
				.valor(new BigDecimal(dto.getPreco()))
				.build();
				
				
		return repository.save(servicoPrestado);
	}

}
