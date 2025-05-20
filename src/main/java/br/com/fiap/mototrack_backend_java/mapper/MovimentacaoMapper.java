package br.com.fiap.mototrack_backend_java.mapper;

import br.com.fiap.mototrack_backend_java.dto.DepartamentoResumoDTO;
import br.com.fiap.mototrack_backend_java.dto.MotoResumoDTO;
import br.com.fiap.mototrack_backend_java.dto.MovimentacaoDTO;
import br.com.fiap.mototrack_backend_java.model.Departamento;
import br.com.fiap.mototrack_backend_java.model.Moto;
import br.com.fiap.mototrack_backend_java.model.Movimentacao;

public class MovimentacaoMapper {

    public static MovimentacaoDTO toDTO(Movimentacao movimentacao) {
        if (movimentacao == null) return null;

        MotoResumoDTO motoResumo = null;
        if (movimentacao.getMoto() != null) {
            motoResumo = new MotoResumoDTO(movimentacao.getMoto().getId());
        }

        DepartamentoResumoDTO departamentoResumo = null;
        if (movimentacao.getDepartamento() != null) {
            departamentoResumo = new DepartamentoResumoDTO(movimentacao.getDepartamento().getId());
        }

        return new MovimentacaoDTO(
                movimentacao.getId(),
                movimentacao.getTimestamp(),
                motoResumo,
                departamentoResumo
        );
    }

    public static Movimentacao toEntity(MovimentacaoDTO dto) {
        if (dto == null) return null;

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTimestamp(dto.getTimestamp());

        if (dto.getMoto() != null) {
            Moto moto = new Moto();
            moto.setId(dto.getMoto().getId());
            movimentacao.setMoto(moto);
        }

        if (dto.getDepartamento() != null) {
            Departamento departamento = new Departamento();
            departamento.setId(dto.getDepartamento().getId());
            movimentacao.setDepartamento(departamento);
        }

        return movimentacao;
    }
}
