package br.com.fiap.mototrack_backend_java.service;

import br.com.fiap.mototrack_backend_java.model.Usuario;
import br.com.fiap.mototrack_backend_java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
