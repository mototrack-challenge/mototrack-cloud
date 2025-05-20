package br.com.fiap.mototrack_backend_java.dto;

import br.com.fiap.mototrack_backend_java.model.StatusType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonPropertyOrder({ "id_status", "tipo", "descricao" })
public class StatusDTO {

    @JsonProperty("id_status")
    private Long id;

    @NotBlank(message = "A descrição do status é obrigatória")
    private String descricao;

    @NotNull(message = "O tipo de status é obrigatório")
    private StatusType tipo;

    public StatusDTO() {
    }

    public StatusDTO(Long id, String descricao, StatusType tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusType getTipo() {
        return tipo;
    }

    public void setTipo(StatusType tipo) {
        this.tipo = tipo;
    }
}
