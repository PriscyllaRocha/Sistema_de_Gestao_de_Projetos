package com.pris.sistemagestao.repository;

import com.pris.sistemagestao.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
