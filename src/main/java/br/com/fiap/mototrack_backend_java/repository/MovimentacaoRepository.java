package br.com.fiap.mototrack_backend_java.repository;

import br.com.fiap.mototrack_backend_java.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    List<Movimentacao> findAllByOrderByIdAsc();
}
