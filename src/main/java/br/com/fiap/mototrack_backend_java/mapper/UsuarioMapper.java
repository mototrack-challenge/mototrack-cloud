package br.com.fiap.mototrack_backend_java.mapper;

import br.com.fiap.mototrack_backend_java.dto.UsuarioDTO;
import br.com.fiap.mototrack_backend_java.model.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDataCriacao()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        // dataCriacao será setado automaticamente no @PrePersist

        return usuario;
    }
}
