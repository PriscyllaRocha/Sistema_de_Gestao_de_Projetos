package com.pris.sistemagestao.repository;

import com.pris.sistemagestao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
