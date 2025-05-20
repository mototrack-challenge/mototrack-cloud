package br.com.fiap.mototrack_backend_java.controller;

import br.com.fiap.mototrack_backend_java.dto.MovimentacaoDTO;
import br.com.fiap.mototrack_backend_java.mapper.MovimentacaoMapper;
import br.com.fiap.mototrack_backend_java.model.Movimentacao;
import br.com.fiap.mototrack_backend_java.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService service;

    public MovimentacaoController(MovimentacaoService service) {
        this.service = service;
    }

    @GetMapping("/listar/todos")
    public List<MovimentacaoDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(MovimentacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public MovimentacaoDTO buscarPorId(@PathVariable Long id) {
        return MovimentacaoMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public MovimentacaoDTO salvar(@RequestBody @Valid MovimentacaoDTO dto) {
        return MovimentacaoMapper.toDTO(service.salvar(MovimentacaoMapper.toEntity(dto)));
    }

    @PutMapping("/atualizar/{id}")
    public MovimentacaoDTO atualizar(@PathVariable Long id, @RequestBody @Valid MovimentacaoDTO dto) {
        Movimentacao movimentacao = MovimentacaoMapper.toEntity(dto);
        movimentacao.setId(id);
        return MovimentacaoMapper.toDTO(service.atualizar(id,movimentacao));
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
