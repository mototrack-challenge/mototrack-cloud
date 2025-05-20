package br.com.fiap.mototrack_backend_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@JsonPropertyOrder({ "id_usuario", "nome", "email", "senha", "dataCriacao" })
public class UsuarioDTO {
    @JsonProperty("id_usuario")
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Size(max = 150, message = "O e-mail deve ter no máximo 150 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 150, message = "A senha deve ter entre 6 e 150 caracteres")
    private String senha;

    private LocalDateTime dataCriacao;

    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nome, String email, String senha, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
