package br.com.fiap.mototrack_backend_java.service;

import br.com.fiap.mototrack_backend_java.model.Status;
import br.com.fiap.mototrack_backend_java.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService extends BaseServiceImpl<Status, Long, StatusRepository> {

    public StatusService(StatusRepository repository) {
        super(repository);
    }

    @Override
    public List<Status> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
