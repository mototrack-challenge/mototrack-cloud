package br.com.fiap.mototrack_backend_java.controller;

import br.com.fiap.mototrack_backend_java.dto.DepartamentoDTO;
import br.com.fiap.mototrack_backend_java.mapper.DepartamentoMapper;
import br.com.fiap.mototrack_backend_java.model.Departamento;
import br.com.fiap.mototrack_backend_java.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping("/listar/todos")
    public List<DepartamentoDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(DepartamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public DepartamentoDTO buscarPorId(@PathVariable Long id) {
        return DepartamentoMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public DepartamentoDTO salvar(@RequestBody @Valid DepartamentoDTO dto) {
        return DepartamentoMapper.toDTO(service.salvar(DepartamentoMapper.toEntity(dto)));
    }

    @PutMapping("/atualizar/{id}")
    public DepartamentoDTO atualizar(@PathVariable Long id, @RequestBody @Valid DepartamentoDTO dto) {
        Departamento departamento = DepartamentoMapper.toEntity(dto);
        departamento.setId(id);
        return DepartamentoMapper.toDTO(service.atualizar(id,departamento));
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
