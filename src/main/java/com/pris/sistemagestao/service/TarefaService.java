package com.pris.sistemagestao.service;

import com.pris.sistemagestao.model.Tarefa;
import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.model.Projeto;
import com.pris.sistemagestao.repository.TarefaRepository;
import com.pris.sistemagestao.repository.UsuarioRepository;
import com.pris.sistemagestao.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;

    public TarefaService(TarefaRepository tarefaRepository,
                         UsuarioRepository usuarioRepository,
                         ProjetoRepository projetoRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
        this.projetoRepository = projetoRepository;
    }

    public Tarefa criar(Tarefa tarefa) {
        if (tarefa.getUsuario() != null) {
            Usuario usuario = usuarioRepository.findById(tarefa.getUsuario().getIdUsuario()).orElse(null);
            tarefa.setUsuario(usuario);
        }
        if (tarefa.getProjeto() != null) {
            Projeto projeto = projetoRepository.findById(tarefa.getProjeto().getIdProjeto()).orElse(null);
            tarefa.setProjeto(projeto);
        }
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodos() { return tarefaRepository.findAll(); }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        Tarefa existente = buscarPorId(id);
        if (existente == null) return null;

        existente.setTitulo(tarefaAtualizada.getTitulo());
        existente.setDescricao(tarefaAtualizada.getDescricao());
        existente.setDataCriacao(tarefaAtualizada.getDataCriacao());
        existente.setDataConclusao(tarefaAtualizada.getDataConclusao());
        existente.setPrioridade(tarefaAtualizada.getPrioridade());
        existente.setStatus(tarefaAtualizada.getStatus());

        if (tarefaAtualizada.getUsuario() != null) {
            Usuario usuario = usuarioRepository.findById(tarefaAtualizada.getUsuario().getIdUsuario()).orElse(null);
            existente.setUsuario(usuario);
        }
        if (tarefaAtualizada.getProjeto() != null) {
            Projeto projeto = projetoRepository.findById(tarefaAtualizada.getProjeto().getIdProjeto()).orElse(null);
            existente.setProjeto(projeto);
        }

        return tarefaRepository.save(existente);
    }

    public void deletar(Long id) { tarefaRepository.deleteById(id); }

    public List<Tarefa> listarTarefasPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) return new ArrayList<>();
        return usuario.getTarefas();
    }

    public List<Tarefa> listarTarefasPorProjeto(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId).orElse(null);
        if (projeto == null) return new ArrayList<>();
        return projeto.getTarefas();
    }
}
