package br.com.fiap.mototrack_backend_java.controller;

import br.com.fiap.mototrack_backend_java.dto.UsuarioDTO;
import br.com.fiap.mototrack_backend_java.mapper.UsuarioMapper;
import br.com.fiap.mototrack_backend_java.model.Usuario;
import br.com.fiap.mototrack_backend_java.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/listar/todos")
    public List<UsuarioDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return UsuarioMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public UsuarioDTO salvar(@RequestBody @Valid UsuarioDTO dto) {
        return UsuarioMapper.toDTO(service.salvar(UsuarioMapper.toEntity(dto)));
    }

    @PutMapping("/atualizar/{id}")
    public UsuarioDTO atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuario.setId(id);
        return UsuarioMapper.toDTO(service.atualizar(id,usuario));
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
