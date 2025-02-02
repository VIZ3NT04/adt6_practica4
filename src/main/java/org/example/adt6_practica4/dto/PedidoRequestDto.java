package org.example.adt6_practica4.dto;

import org.example.adt6_practica4.model.Usuario;

public class PedidoRequestDto {
    private String description;
    private Integer usuarioId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
