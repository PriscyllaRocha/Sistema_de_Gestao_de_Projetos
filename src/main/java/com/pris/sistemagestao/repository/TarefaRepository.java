package com.pris.sistemagestao.repository;

import com.pris.sistemagestao.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
