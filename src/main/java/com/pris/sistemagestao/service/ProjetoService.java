package com.pris.sistemagestao.service;

import com.pris.sistemagestao.model.Projeto;
import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

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

    public void deletar(Long id) {
        projetoRepository.deleteById(id);
    }

    public Projeto adicionarParticipante(Long projetoId, Usuario usuario) {
        Projeto projeto = buscarPorId(projetoId);
        if (projeto == null) return null;

        if (projeto.getParticipantes() == null) {
            projeto.setParticipantes(new ArrayList<>());
        }

        projeto.getParticipantes().add(usuario);
        return projetoRepository.save(projeto);
    }

    public Projeto removerParticipante(Long projetoId, Usuario usuario) {
        Projeto projeto = buscarPorId(projetoId);
        if (projeto == null || projeto.getParticipantes() == null) return null;

        projeto.getParticipantes().remove(usuario);
        return projetoRepository.save(projeto);
    }
}
