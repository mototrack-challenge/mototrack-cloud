package br.com.fiap.mototrack_backend_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "id_alerta", "mensagem", "dataAlerta", "moto" })
public class AlertaDTO {

    @JsonProperty("id_alerta")
    private Long id;

    @NotBlank(message = "A mensagem do alerta é obrigatória")
    @Size(max = 200)
    private String mensagem;

    private LocalDateTime dataAlerta;

    private MotoResumoDTO moto;

    public AlertaDTO() {}

    public AlertaDTO(Long id, String mensagem, LocalDateTime dataAlerta, MotoResumoDTO moto) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataAlerta = dataAlerta;
        this.moto = moto;
    }

    // Getters e Setters
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

    public MotoResumoDTO getMoto() {
        return moto;
    }

    public void setMoto(MotoResumoDTO moto) {
        this.moto = moto;
    }
}
