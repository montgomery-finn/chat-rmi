/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.repositories;

import cliente.IClienteCallback;
import java.util.List;
import shared.models.Conversa;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public interface ICallbackRepository {
    public void Add(IClienteCallback callback);
    public void Remove(IClienteCallback callback);
    public List<IClienteCallback> GetAll();
    public List<IClienteCallback> GetByConversa(Conversa conversa);
    public IClienteCallback GetByUsuario(Usuario usuario);
}
