package com.pris.sistemagestao.controller;

import com.pris.sistemagestao.model.Tarefa;
import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.service.TarefaService;
import com.pris.sistemagestao.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;
    private final UsuarioService usuarioService;

    public TarefaController(TarefaService tarefaService, UsuarioService usuarioService) {
        this.tarefaService = tarefaService;
        this.usuarioService = usuarioService;
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

    @PostMapping("/{idTarefa}/usuario/{idUsuario}")
    public Tarefa atribuirUsuario(@PathVariable Long idTarefa, @PathVariable Long idUsuario) {
        Tarefa tarefa = tarefaService.buscarPorId(idTarefa);
        Usuario usuario = usuarioService.buscarPorId(idUsuario);
        return tarefaService.atribuirUsuario(tarefa, usuario);
    }
}
