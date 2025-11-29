package com.pris.sistemagestao.service;

import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario existente = buscarPorId(id);
        if (existente == null) return null;

        existente.setNome(usuarioAtualizado.getNome());
        existente.setDescricao(usuarioAtualizado.getDescricao());
        existente.setEmail(usuarioAtualizado.getEmail());
        existente.setSenha(usuarioAtualizado.getSenha());
        existente.setDataNascimento(usuarioAtualizado.getDataNascimento());
        existente.setStatus(usuarioAtualizado.getStatus());

        return usuarioRepository.save(existente);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
