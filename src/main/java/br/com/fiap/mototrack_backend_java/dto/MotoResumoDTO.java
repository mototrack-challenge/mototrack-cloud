package br.com.fiap.mototrack_backend_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotoResumoDTO {

    @JsonProperty("id_moto")
    private Long id;

    public MotoResumoDTO() {}

    public MotoResumoDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
