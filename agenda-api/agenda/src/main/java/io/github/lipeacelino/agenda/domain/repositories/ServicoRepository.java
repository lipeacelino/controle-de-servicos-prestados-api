package io.github.lipeacelino.agenda.domain.repositories;

import io.github.lipeacelino.agenda.domain.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}