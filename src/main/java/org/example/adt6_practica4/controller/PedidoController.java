package org.example.adt6_practica4.controller;

import jakarta.validation.Valid;
import org.example.adt6_practica4.dto.PedidoRequestDto;
import org.example.adt6_practica4.dto.PedidoResponseDto;
import org.example.adt6_practica4.dto.UsuarioRequestDto;
import org.example.adt6_practica4.dto.UsuarioResponseDto;
import org.example.adt6_practica4.model.Pedido;
import org.example.adt6_practica4.model.Usuario;
import org.example.adt6_practica4.service.IServicePedido;
import org.example.adt6_practica4.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private IServicePedido service;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> mostrarTodos() {
        List<PedidoResponseDto> pedidos = service.listar();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> mostrarUno(@PathVariable("id") Integer id) {
        PedidoResponseDto pedido = service.listarPorId(id);
        return new ResponseEntity<>(pedido,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> insert(@Valid @RequestBody PedidoRequestDto p) {
        Pedido pedido = service.registrar(p);
        return new ResponseEntity<>(pedido,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> modificar(@PathVariable("id") Integer id, @Valid @RequestBody PedidoRequestDto p) {
        Pedido pedido = service.modificar(id,p);
        if (pedido == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pedido,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
