package com.pris.sistemagestao.controller;

import com.pris.sistemagestao.model.Tarefa;
import com.pris.sistemagestao.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Tarefa> listarTarefasPorUsuario(@PathVariable Long usuarioId) {
        return tarefaService.listarTarefasPorUsuario(usuarioId);
    }

    @GetMapping("/projeto/{projetoId}")
    public List<Tarefa> listarTarefasPorProjeto(@PathVariable Long projetoId) {
        return tarefaService.listarTarefasPorProjeto(projetoId);
    }
}
