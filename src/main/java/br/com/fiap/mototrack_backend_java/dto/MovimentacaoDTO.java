package br.com.fiap.mototrack_backend_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "id_movimentacao", "timestamp", "departamento" })
public class MovimentacaoDTO {

    @JsonProperty("id_movimentacao")
    private Long id;

    private LocalDateTime timestamp;

    private MotoResumoDTO moto;

    private DepartamentoResumoDTO departamento;

    public MovimentacaoDTO() {
    }

    public MovimentacaoDTO(Long id, LocalDateTime timestamp, MotoResumoDTO moto, DepartamentoResumoDTO departamento) {
        this.id = id;
        this.timestamp = timestamp;
        this.moto = moto;
        this.departamento = departamento;
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

    public MotoResumoDTO getMoto() {
        return moto;
    }

    public void setMoto(MotoResumoDTO motoId) {
        this.moto = motoId;
    }

    public DepartamentoResumoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoResumoDTO departamento) {
        this.departamento = departamento;
    }
}
