package br.com.fiap.mototrack_backend_java.controller;

import br.com.fiap.mototrack_backend_java.dto.MotoDTO;
import br.com.fiap.mototrack_backend_java.dto.UsuarioDTO;
import br.com.fiap.mototrack_backend_java.mapper.MotoMapper;
import br.com.fiap.mototrack_backend_java.mapper.UsuarioMapper;
import br.com.fiap.mototrack_backend_java.model.Moto;
import br.com.fiap.mototrack_backend_java.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private final MotoService service;

    public MotoController(MotoService service) {
        this.service = service;
    }

    @GetMapping("/listar/todos")
    public List<MotoDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(MotoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public MotoDTO buscarPorId(@PathVariable Long id) {
        return MotoMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public MotoDTO salvar(@RequestBody @Valid MotoDTO dto) {
        return MotoMapper.toDTO(service.salvar(MotoMapper.toEntity(dto)));
    }

    @PutMapping("/atualizar/{id}")
    public MotoDTO atualizar(@PathVariable Long id, @RequestBody @Valid MotoDTO dto) {
        Moto moto = MotoMapper.toEntity(dto);
        moto.setId(id);
        return MotoMapper.toDTO(service.atualizar(id,moto));
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
