package br.com.fiap.mototrack_backend_java.dto;

import br.com.fiap.mototrack_backend_java.model.Alerta;
import br.com.fiap.mototrack_backend_java.model.Movimentacao;
import br.com.fiap.mototrack_backend_java.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;

import java.util.List;

@JsonPropertyOrder({ "id_moto", "placa", "modelo", "status", "movimentacoes", "alertas" })
public class MotoDTO {
    @JsonProperty("id_moto")
    private Long id;

    @NotBlank(message = "A placa da moto é obrigatória")
    @Size(min = 7, max = 7)
    private String placa;

    @NotBlank(message = "O modelo da moto é obrigatório")
    @Size(max = 100)
    private String modelo;

    @NotNull(message = "O status é obrigatório")
    private Status status;

    private List<Movimentacao> movimentacoes;

    private List<Alerta> alertas;

    public MotoDTO() {}

    public MotoDTO(Long id, String placa, String modelo, Status status, List<Movimentacao> movimentacoes, List<Alerta> alertas) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.status = status;
        this.movimentacoes = movimentacoes;
        this.alertas = alertas;
    }

    // Getters e Setters
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

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }
}
