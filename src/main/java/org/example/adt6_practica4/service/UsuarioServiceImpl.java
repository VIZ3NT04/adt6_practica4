package org.example.adt6_practica4.service;

import org.example.adt6_practica4.dto.UsuarioRequestDto;
import org.example.adt6_practica4.dto.UsuarioResponseDto;
import org.example.adt6_practica4.model.Usuario;
import org.example.adt6_practica4.repository.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IServiceUsuario{
    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Usuario registrar(UsuarioRequestDto usuario) {
        Usuario user = modelMapper.map(usuario, Usuario.class);
        return repo.save(user);
    }

    @Override
    public Usuario modificar(Integer id,UsuarioRequestDto usuario) {
        Optional<Usuario> op = repo.findById(id);

        if (op.isPresent()) {
            Usuario user = op.get();
            user.setNombre(usuario.getNombre());
            user.setApellidos(usuario.getApellidos());
            user.setEmail(usuario.getEmail());
            user.setPassword(usuario.getPassword());
            return repo.save(user);
        }
        return null;
    }

    @Override
    public List<UsuarioResponseDto> listar() {
        return repo.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario,UsuarioResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDto listarPorId(Integer id) {
        Optional<Usuario> usuario = repo.findById(id);
        if (usuario.isPresent()) return modelMapper.map(usuario, UsuarioResponseDto.class);
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
