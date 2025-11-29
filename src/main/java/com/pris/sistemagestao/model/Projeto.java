package com.pris.sistemagestao.model;

import com.pris.sistemagestao.enums.StatusProjeto;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjeto;

    private String nome;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataConclusao;

    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Usuario responsavel;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    @ManyToMany
    @JoinTable(
        name = "projeto_participantes",
        joinColumns = @JoinColumn(name = "id_projeto"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> participantes = new ArrayList<>();

    public Projeto() {}

    public Long getIdProjeto() {
        return idProjeto;
    }
    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataConclusao() {
        return dataConclusao;
    }
    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    public StatusProjeto getStatus() {
        return status;
    }
    public void setStatus(StatusProjeto status) {
        this.status = status;
    }
    public Usuario getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    public List<Usuario> getParticipantes() {
        return participantes;
    }
    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }
}
