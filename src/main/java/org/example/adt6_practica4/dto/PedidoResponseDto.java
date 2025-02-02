package org.example.adt6_practica4.dto;

import org.example.adt6_practica4.model.Usuario;

import java.time.LocalDateTime;

public class PedidoResponseDto {
    private String description;

    private LocalDateTime fechaPedido;

    private String usuarioNombre;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
}
