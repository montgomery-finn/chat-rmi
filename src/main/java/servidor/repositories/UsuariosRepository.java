/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.repositories;

import shared.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sandr
 */

public class UsuariosRepository implements IUsuariosRepository {
    private List<Usuario> _usuarios;

    public UsuariosRepository() {
        _usuarios = new ArrayList<>();
    }
    
    @Override
    public void Add(Usuario usuario) {
        _usuarios.add(usuario);
    }

    @Override
    public Usuario GetByName(String name) {
        var usuario = _usuarios.stream().filter(u -> u.GetName().equals(name)).findAny().orElse(null);
        return usuario;
    }

    @Override
    public List<Usuario> GetAll() {
        return _usuarios;
    }

    @Override
    public List<Usuario> GetOnlines() {
        var usuarios = _usuarios.stream().filter(u -> u.GetOnline()).collect(Collectors.toList());
        
        return usuarios;
    }
    
    
    
}
