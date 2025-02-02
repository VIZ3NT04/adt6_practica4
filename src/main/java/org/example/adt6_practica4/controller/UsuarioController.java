package org.example.adt6_practica4.controller;

import jakarta.validation.Valid;
import org.example.adt6_practica4.dto.UsuarioRequestDto;
import org.example.adt6_practica4.dto.UsuarioResponseDto;
import org.example.adt6_practica4.model.Usuario;
import org.example.adt6_practica4.repository.IUsuarioRepository;
import org.example.adt6_practica4.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IServiceUsuario service;

    @GetMapping
     public ResponseEntity<List<UsuarioResponseDto>> mostrarTodos() {
        List<UsuarioResponseDto> users = service.listar();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> mostrarUno(@PathVariable("id") Integer id) {
        UsuarioResponseDto user = service.listarPorId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@Valid @RequestBody UsuarioRequestDto u) {
        Usuario usuario = service.registrar(u);
        return new ResponseEntity<>(usuario,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable("id") Integer id, @Valid @RequestBody UsuarioRequestDto u) {
        Usuario usuario = service.modificar(id,u);
        if (usuario == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
