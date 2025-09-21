package br.com.fiap.mototrack_backend_java.service;

import br.com.fiap.mototrack_backend_java.model.Alerta;
import br.com.fiap.mototrack_backend_java.model.Moto;
import br.com.fiap.mototrack_backend_java.model.Movimentacao;
import br.com.fiap.mototrack_backend_java.model.enums.ModeloMoto;
import br.com.fiap.mototrack_backend_java.model.enums.Status;
import br.com.fiap.mototrack_backend_java.model.enums.TipoDepartamento;
import br.com.fiap.mototrack_backend_java.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Transactional(readOnly = true)
    public List<Moto> listarMotos(String placa, String chassi, ModeloMoto modelo,
                                  Status status) {

        String placaPattern = (placa == null || placa.isBlank()) ? null : "%" + placa.toUpperCase() + "%";
        String chassiPattern = (chassi == null || chassi.isBlank()) ? null : "%" + chassi.toUpperCase() + "%";

        List<Moto> motos = motoRepository.findByFiltros(placaPattern, chassiPattern, modelo, status);

        motos.forEach(m -> {
            m.setMovimentacoes(m.getMovimentacoes().stream()
                    .sorted(Comparator.comparing(Movimentacao::getDataMovimentacao).reversed())
                    .limit(5)
                    .toList());

            m.setAlertas(m.getAlertas().stream()
                    .sorted(Comparator.comparing(Alerta::getDataAlerta).reversed())
                    .limit(5)
                    .toList());
        });

        return motos;
    }

    @Transactional(readOnly = true)
    public Map<String, Long> resumirCards() {
        Map<String, Long> resumo = new HashMap<>();
        resumo.put("cadastradas", motoRepository.count());
        resumo.put("avaliacao", motoRepository.countByDepartamentoAtual(TipoDepartamento.AVALIACAO));
        resumo.put("manutencao", motoRepository.countByDepartamentoAtual(TipoDepartamento.MANUTENCAO));
        resumo.put("prontasParaUso", motoRepository.countByDepartamentoAtual(TipoDepartamento.PRONTA_PARA_USO));
        return resumo;
    }

    @Transactional(readOnly = true)
    public Moto buscarPorId(Long id) {
        return motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto com id: " + id + " não encontrada"));
    }

    @Transactional
    public Moto salvar(Moto moto) {
        if (moto.getPlaca() != null) {
            moto.setPlaca(moto.getPlaca().toUpperCase());
        }
        if (moto.getChassi() != null) {
            moto.setChassi(moto.getChassi().toUpperCase());
        }

        return motoRepository.save(moto);
    }

    public boolean existePorPlaca(String placa) {
        return motoRepository.existsByPlacaIgnoreCase(placa);
    }

    public boolean existePorChassi(String chassi) {
        return motoRepository.existsByChassiIgnoreCase(chassi);
    }

    @Transactional
    public Moto atualizar(Long id, Moto motoNova) {
        var motoAtual = buscarPorId(id);

        motoAtual.setId(id);
        motoAtual.setPlaca(motoNova.getPlaca().toUpperCase());
        motoAtual.setChassi(motoNova.getChassi().toUpperCase());
        motoAtual.setModelo(motoNova.getModelo());
        motoAtual.setStatus(motoNova.getStatus());


        return motoRepository.save(motoAtual);
    }

    @Transactional
    public void deletar(Long id) {
        var moto = buscarPorId(id);
        motoRepository.delete(moto);
    }
}
