package com.pris.sistemagestao.model;

import com.pris.sistemagestao.enums.Prioridade;
import com.pris.sistemagestao.enums.StatusTarefa;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    private String titulo;

    private String descricao;

    private LocalDate dataCriacao;

    private LocalDate dataConclusao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Tarefa() {}

    public Long getIdTarefa() {
        return idTarefa;
    }
    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public LocalDate getDataConclusao() {
        return dataConclusao;
    }
    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public StatusTarefa getStatus() {
        return status;
    }
    public void setStatus(StatusTarefa status) {
        this.status = status;
    }
    public Projeto getProjeto() {
        return projeto;
    }
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
