package com.pris.sistemagestao.controller;

import com.pris.sistemagestao.model.Usuario;
import com.pris.sistemagestao.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
