package br.com.fiap.mototrack_backend_java.mapper;

import br.com.fiap.mototrack_backend_java.dto.DepartamentoDTO;
import br.com.fiap.mototrack_backend_java.model.Departamento;

public class DepartamentoMapper {

    public static DepartamentoDTO toDTO(Departamento departamento){
        if (departamento == null) return null;

        return new DepartamentoDTO(
                departamento.getId(),
                departamento.getNome(),
                departamento.getTipo()
        );
    }

    public static Departamento toEntity(DepartamentoDTO dto) {
        if (dto == null) return null;

        Departamento departamento = new Departamento();
        departamento.setNome(dto.getNome());
        departamento.setTipo(dto.getTipo());

        return departamento;
    }
}
