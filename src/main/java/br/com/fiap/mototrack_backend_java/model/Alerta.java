package br.com.fiap.mototrack_backend_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "id_alerta", "mensagem", "dataAlerta" })
@Entity
@Table(name = "mt_alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alerta_seq")
    @SequenceGenerator(name = "alerta_seq", sequenceName = "ALERTA_SEQ", allocationSize = 1)
    @Column(name = "id_alerta")
    @JsonProperty("id_alerta")
    private Long id;

    @Column(nullable = false)
    private String mensagem;

    @Column(name = "data_alerta", nullable = false)
    private LocalDateTime dataAlerta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moto_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Moto moto;

    public Alerta() {
    }

    public Alerta(String mensagem, LocalDateTime dataAlerta, Moto moto) {
        this.mensagem = mensagem;
        this.dataAlerta = dataAlerta;
        this.moto = moto;
    }

    @PrePersist
    protected void onCreate() {
        if (this.dataAlerta == null) {
            this.dataAlerta = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDateTime dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}
