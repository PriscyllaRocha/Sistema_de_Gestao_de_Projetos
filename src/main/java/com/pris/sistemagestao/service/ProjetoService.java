package com.pris.sistemagestao.service;

import com.pris.sistemagestao.model.Projeto;
import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

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
        existente.setUsuarios(projetoAtualizado.getUsuarios());

        return projetoRepository.save(existente);
    }

    public void deletar(Long id) {
        projetoRepository.deleteById(id);
    }

    public List<Usuario> listarUsuarios(Projeto projeto) {
        return new ArrayList<>(projeto.getUsuarios());
    }

    public Projeto adicionarUsuario(Projeto projeto, Usuario usuario) {
        projeto.getUsuarios().add(usuario);
        return projetoRepository.save(projeto);
    }

    public Projeto removerUsuario(Projeto projeto, Usuario usuario) {
        projeto.getUsuarios().remove(usuario);
        return projetoRepository.save(projeto);
    }
}
