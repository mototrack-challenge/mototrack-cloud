package br.com.fiap.mototrack_backend_java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.List;

@JsonPropertyOrder({ "id_departamento", "nome", "tipo" })
@Entity
@Table(name = "mt_departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamento_seq")
    @SequenceGenerator(name = "departamento_seq", sequenceName = "DEPARTAMENTO_SEQ", allocationSize = 1)
    @Column(name = "id_departamento")
    @JsonProperty("id_departamento")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private DepartamentoType tipo;

    @OneToMany(mappedBy = "departamento")
    @JsonIgnore
    private List<Movimentacao> movimentacoes;

    public Departamento() {
    }

    public Departamento(String nome, DepartamentoType tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DepartamentoType getTipo() {
        return tipo;
    }

    public void setTipo(DepartamentoType tipo) {
        this.tipo = tipo;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }
}
