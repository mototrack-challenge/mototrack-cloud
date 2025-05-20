package br.com.fiap.mototrack_backend_java.controller;

import br.com.fiap.mototrack_backend_java.dto.AlertaDTO;
import br.com.fiap.mototrack_backend_java.mapper.AlertaMapper;
import br.com.fiap.mototrack_backend_java.model.Alerta;
import br.com.fiap.mototrack_backend_java.service.AlertaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @GetMapping("/listar/todos")
    public List<AlertaDTO> lisarTodos() {
        return service.listarTodos()
                .stream()
                .map(AlertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public AlertaDTO buscarPorId(@PathVariable Long id) {
        return AlertaMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public AlertaDTO salvar(@RequestBody @Valid AlertaDTO dto) {
        return AlertaMapper.toDTO(service.salvar(AlertaMapper.toEntity(dto)));
    }

    @PutMapping("/atualizar/{id}")
    public AlertaDTO atualizar(@PathVariable Long id, @RequestBody @Valid AlertaDTO dto) {
        Alerta alerta = AlertaMapper.toEntity(dto);
        alerta.setId(id);
        return AlertaMapper.toDTO(service.atualizar(id,alerta));
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
