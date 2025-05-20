package br.com.fiap.mototrack_backend_java.dto;

import br.com.fiap.mototrack_backend_java.model.DepartamentoType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonPropertyOrder({ "id_departamento", "nome", "tipo" })
public class DepartamentoDTO {

    @JsonProperty("id_departamento")
    private Long id;

    @NotBlank(message = "O nome do departamento é obrigatório")
    private String nome;

    @NotNull(message = "O tipo do departamento é obrigatório")
    private DepartamentoType tipo;

    public DepartamentoDTO() {
    }

    public DepartamentoDTO(Long id, String nome, DepartamentoType tipo) {
        this.id = id;
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
}
