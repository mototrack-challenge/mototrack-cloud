package br.com.fiap.mototrack_backend_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "id_movimentacao", "timestamp", "departamento" })
@Entity
@Table(name = "mt_movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimentacao_seq")
    @SequenceGenerator(name = "movimentacao_seq", sequenceName = "MOVIMENTACAO_SEQ", allocationSize = 1)
    @Column(name = "id_movimentacao")
    @JsonProperty("id_movimentacao")
    private Long id;

    @Column(name = "data_movimentacao")
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moto_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Moto moto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Movimentacao() {
    }

    public Movimentacao(LocalDateTime timestamp, Moto moto, Departamento departamento) {
        this.timestamp = timestamp;
        this.moto = moto;
        this.departamento = departamento;
    }

    @PrePersist
    protected void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
