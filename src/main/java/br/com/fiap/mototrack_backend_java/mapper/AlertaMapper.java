package br.com.fiap.mototrack_backend_java.mapper;

import br.com.fiap.mototrack_backend_java.dto.AlertaDTO;
import br.com.fiap.mototrack_backend_java.dto.MotoResumoDTO;
import br.com.fiap.mototrack_backend_java.model.Alerta;
import br.com.fiap.mototrack_backend_java.model.Moto;

public class AlertaMapper {

    public static AlertaDTO toDTO(Alerta alerta) {
        if (alerta == null) return null;

        MotoResumoDTO motoResumo = null;
        if (alerta.getMoto() != null) {
            motoResumo = new MotoResumoDTO(alerta.getMoto().getId());
        }

        return new AlertaDTO(
                alerta.getId(),
                alerta.getMensagem(),
                alerta.getDataAlerta(),
                motoResumo
        );
    }

    public static Alerta toEntity(AlertaDTO dto) {
        if (dto == null) return null;

        Alerta alerta = new Alerta();
        alerta.setMensagem(dto.getMensagem());
        alerta.setDataAlerta(dto.getDataAlerta());

        if (dto.getMoto() != null) {
            Moto moto = new Moto();
            moto.setId(dto.getMoto().getId());
            alerta.setMoto(moto);
        }

        return alerta;
    }
}
