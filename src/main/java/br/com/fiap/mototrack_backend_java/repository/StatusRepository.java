package br.com.fiap.mototrack_backend_java.repository;

import br.com.fiap.mototrack_backend_java.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAllByOrderByIdAsc();
}
