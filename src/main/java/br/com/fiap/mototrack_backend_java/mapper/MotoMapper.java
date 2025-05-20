package br.com.fiap.mototrack_backend_java.mapper;

import br.com.fiap.mototrack_backend_java.dto.MotoDTO;
import br.com.fiap.mototrack_backend_java.model.Moto;

public class MotoMapper {
    public static MotoDTO toDTO(Moto moto) {
        if (moto == null) return null;

        return new MotoDTO(
                moto.getId(),
                moto.getPlaca(),
                moto.getModelo(),
                moto.getStatus(),
                moto.getMovimentacoes(),
                moto.getAlertas()
        );
    }

    public static Moto toEntity(MotoDTO dto) {
        if (dto == null) return null;

        Moto moto = new Moto();
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setStatus(dto.getStatus());

        return moto;
    }
}
