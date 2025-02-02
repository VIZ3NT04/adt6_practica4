package org.example.adt6_practica4.service;

import org.example.adt6_practica4.dto.UsuarioRequestDto;
import org.example.adt6_practica4.dto.UsuarioResponseDto;
import org.example.adt6_practica4.model.Usuario;

import java.util.List;

public interface IServiceUsuario {
    Usuario registrar(UsuarioRequestDto usuario);
    Usuario modificar(Integer id,UsuarioRequestDto usuario);
    List<UsuarioResponseDto> listar();
    UsuarioResponseDto listarPorId(Integer id);
    void eliminar(Integer id);
}
