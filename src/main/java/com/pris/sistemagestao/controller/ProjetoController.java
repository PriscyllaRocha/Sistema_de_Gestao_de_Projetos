package com.pris.sistemagestao.controller;

import com.pris.sistemagestao.model.Projeto;
import com.pris.sistemagestao.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public Projeto criar(@RequestBody Projeto projeto) {
        return projetoService.criar(projeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return projetoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return projetoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Projeto atualizar(@PathVariable Long id, @RequestBody Projeto projeto) {
        return projetoService.atualizar(id, projeto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        projetoService.deletar(id);
    }
}
