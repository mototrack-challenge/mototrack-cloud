package br.com.fiap.mototrack_backend_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.List;

@JsonPropertyOrder({ "id_moto", "placa", "modelo", "status", "movimentacoes", "alertas" })
@Entity
@Table(name = "mt_motos")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    @SequenceGenerator(name = "moto_seq", sequenceName = "MOTO_SEQ", allocationSize = 1)
    @Column(name = "id_moto")
    @JsonProperty("id_moto")
    private Long id;

    @Column(nullable = false, length = 7, unique = true)
    private String placa;

    @Column(nullable = false, length = 100)
    private String modelo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "moto", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    @OrderBy("timestamp ASC")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "moto", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    @OrderBy("dataAlerta ASC")
    private List<Alerta> alertas;

    public Moto() {
    }

    public Moto(String placa, String modelo, Status status) {
        this.placa = placa;
        this.modelo = modelo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }
}
