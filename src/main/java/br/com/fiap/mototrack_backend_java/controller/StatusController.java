package br.com.fiap.mototrack_backend_java.controller;

import br.com.fiap.mototrack_backend_java.dto.DepartamentoDTO;
import br.com.fiap.mototrack_backend_java.dto.StatusDTO;
import br.com.fiap.mototrack_backend_java.mapper.DepartamentoMapper;
import br.com.fiap.mototrack_backend_java.mapper.StatusMapper;
import br.com.fiap.mototrack_backend_java.model.Status;
import br.com.fiap.mototrack_backend_java.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping("/listar/todos")
    public List<StatusDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(StatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public StatusDTO buscarPorId(@PathVariable Long id) {
        return StatusMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public StatusDTO salvar(@RequestBody @Valid StatusDTO dto) {
        return StatusMapper.toDTO(service.salvar(StatusMapper.toEntity(dto)));
    }

    @PutMapping("/atualizar/{id}")
    public StatusDTO atualizar(@PathVariable Long id, @RequestBody @Valid StatusDTO dto) {
        Status status = StatusMapper.toEntity(dto);
        status.setId(id);
        return StatusMapper.toDTO(service.atualizar(id,status));
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
