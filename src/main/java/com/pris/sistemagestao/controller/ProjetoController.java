package com.pris.sistemagestao.controller;

import com.pris.sistemagestao.model.Projeto;
import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.service.ProjetoService;
import com.pris.sistemagestao.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;
    private final UsuarioService usuarioService;

    public ProjetoController(ProjetoService projetoService, UsuarioService usuarioService) {
        this.projetoService = projetoService;
        this.usuarioService = usuarioService;
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

    @PostMapping("/{idProjeto}/usuarios/{idUsuario}")
    public Projeto adicionarUsuario(@PathVariable Long idProjeto, @PathVariable Long idUsuario) {
        Projeto projeto = projetoService.buscarPorId(idProjeto);
        Usuario usuario = usuarioService.buscarPorId(idUsuario);
        return projetoService.adicionarUsuario(projeto, usuario);
    }

    @DeleteMapping("/{idProjeto}/usuarios/{idUsuario}")
    public Projeto removerUsuario(@PathVariable Long idProjeto, @PathVariable Long idUsuario) {
        Projeto projeto = projetoService.buscarPorId(idProjeto);
        Usuario usuario = usuarioService.buscarPorId(idUsuario);
        return projetoService.removerUsuario(projeto, usuario);
    }
}
