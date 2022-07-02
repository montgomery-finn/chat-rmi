/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.repositories;

import java.util.List;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public interface IUsuariosRepository {
    public void Add(Usuario usuario);
    public Usuario GetByName(String string);
    public List<Usuario> GetAll();
    public List<Usuario> GetOnlines();
}
