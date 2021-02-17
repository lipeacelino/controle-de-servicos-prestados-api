package io.github.lipeacelino.agenda.domain.repositories;

import io.github.lipeacelino.agenda.domain.entities.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}