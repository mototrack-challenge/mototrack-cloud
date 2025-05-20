package br.com.fiap.mototrack_backend_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartamentoResumoDTO {

    @JsonProperty("id_departamento")
    private Long id;

    public DepartamentoResumoDTO() {}

    public DepartamentoResumoDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
