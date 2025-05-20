package br.com.fiap.mototrack_backend_java.service;

import br.com.fiap.mototrack_backend_java.model.Departamento;
import br.com.fiap.mototrack_backend_java.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService extends BaseServiceImpl<Departamento, Long, DepartamentoRepository> {

    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    @Override
    public List<Departamento> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
