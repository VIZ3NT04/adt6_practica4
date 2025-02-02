package org.example.adt6_practica4.service;

import org.example.adt6_practica4.dto.PedidoRequestDto;
import org.example.adt6_practica4.dto.PedidoResponseDto;
import org.example.adt6_practica4.dto.UsuarioResponseDto;
import org.example.adt6_practica4.model.Pedido;
import org.example.adt6_practica4.model.Usuario;
import org.example.adt6_practica4.repository.IPedidoRepository;
import org.example.adt6_practica4.repository.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements IServicePedido{
    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private IUsuarioRepository repoUser;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Pedido registrar(PedidoRequestDto pedido) {
        Pedido pedidoFinal = modelMapper.map(pedido,Pedido.class);
        return repo.save(pedidoFinal);
    }

    @Override
    public Pedido modificar(Integer id,PedidoRequestDto pedido) {
        Optional<Pedido> op = repo.findById(id);
        if (op.isPresent()) {
            Pedido pedidoFinal = op.get();
            pedidoFinal.setDescription(pedido.getDescription());
            Optional<Usuario> userOp = repoUser.findById(pedido.getUsuarioId());
            if (userOp.isPresent()) {
                pedidoFinal.setUsuario(userOp.get());
            }

            return repo.save(pedidoFinal);
        }
        return null;
    }

    @Override
    public List<PedidoResponseDto> listar() {
        return repo.findAll()
                .stream()
                .map(pedido -> modelMapper.map(pedido, PedidoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoResponseDto listarPorId(Integer id) {
        Optional<Pedido> pedido = repo.findById(id);
        PedidoResponseDto pResDto = modelMapper.map(pedido, PedidoResponseDto.class);
        return pResDto;
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
