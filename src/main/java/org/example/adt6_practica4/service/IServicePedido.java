package org.example.adt6_practica4.service;

import org.example.adt6_practica4.dto.PedidoRequestDto;
import org.example.adt6_practica4.dto.PedidoResponseDto;
import org.example.adt6_practica4.model.Pedido;
import org.example.adt6_practica4.model.Usuario;

import java.util.List;

public interface IServicePedido {
    Pedido registrar(PedidoRequestDto pedido);
    Pedido modificar(Integer id,PedidoRequestDto pedido);
    List<PedidoResponseDto> listar();
    PedidoResponseDto listarPorId(Integer id);
    void eliminar(Integer id);
}
