package com.pris.sistemagestao.service;

import com.pris.sistemagestao.model.Projeto;
import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.repository.ProjetoRepository;
import com.pris.sistemagestao.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProjetoService(ProjetoRepository projetoRepository, UsuarioRepository usuarioRepository) {
        this.projetoRepository = projetoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Projeto criar(Projeto projeto) { return projetoRepository.save(projeto); }
    public List<Projeto> listarTodos() { return projetoRepository.findAll(); }
    public Projeto buscarPorId(Long id) { return projetoRepository.findById(id).orElse(null); }

    public Projeto atualizar(Long id, Projeto projetoAtualizado) {
        Projeto existente = buscarPorId(id);
        if (existente == null) return null;

        existente.setNome(projetoAtualizado.getNome());
        existente.setDescricao(projetoAtualizado.getDescricao());
        existente.setDataInicio(projetoAtualizado.getDataInicio());
        existente.setDataConclusao(projetoAtualizado.getDataConclusao());
        existente.setStatus(projetoAtualizado.getStatus());
        existente.setResponsavel(projetoAtualizado.getResponsavel());

        return projetoRepository.save(existente);
    }

    public void deletar(Long id) { projetoRepository.deleteById(id); }

    public Projeto adicionarUsuario(Long projetoId, Long usuarioId) {
        Projeto projeto = buscarPorId(projetoId);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (projeto == null || usuario == null) return null;

        if (projeto.getUsuarios() == null) projeto.setUsuarios(new ArrayList<>());
        if (!projeto.getUsuarios().contains(usuario)) projeto.getUsuarios().add(usuario);

        return projetoRepository.save(projeto);
    }

    public Projeto removerUsuario(Long projetoId, Long usuarioId) {
        Projeto projeto = buscarPorId(projetoId);
        if (projeto == null || projeto.getUsuarios() == null) return null;

        projeto.getUsuarios().removeIf(u -> u.getIdUsuario().equals(usuarioId));
        return projetoRepository.save(projeto);
    }

    public List<Usuario> listarUsuariosDoProjeto(Long projetoId) {
        Projeto projeto = buscarPorId(projetoId);
        if (projeto == null || projeto.getUsuarios() == null) return new ArrayList<>();
        return projeto.getUsuarios();
    }

    public List<Projeto> listarProjetosDoUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) return new ArrayList<>();

        return projetoRepository.findAll().stream()
                .filter(p -> p.getUsuarios() != null && p.getUsuarios().contains(usuario))
                .collect(Collectors.toList());
    }
}
