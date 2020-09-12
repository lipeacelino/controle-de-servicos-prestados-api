package io.github.lipeacelino.agenda.domain.repositories;

import io.github.lipeacelino.agenda.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
