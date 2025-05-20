package br.com.fiap.mototrack_backend_java.repository;

import br.com.fiap.mototrack_backend_java.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findAllByOrderByIdAsc();

}
