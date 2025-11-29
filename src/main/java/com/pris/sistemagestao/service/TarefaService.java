package com.pris.sistemagestao.service;

import com.pris.sistemagestao.model.Tarefa;
import com.pris.sistemagestao.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodos() {
        return tarefaRepository.findAll();
    }

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
        existente.setProjeto(tarefaAtualizada.getProjeto());
        existente.setUsuario(tarefaAtualizada.getUsuario());

        return tarefaRepository.save(existente);
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }
}
