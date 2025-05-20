package br.com.fiap.mototrack_backend_java.service;

import br.com.fiap.mototrack_backend_java.model.Moto;
import br.com.fiap.mototrack_backend_java.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService extends BaseServiceImpl<Moto, Long, MotoRepository> {

    public MotoService(MotoRepository repository) {
        super(repository);
    }

    @Override
    public List<Moto> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
