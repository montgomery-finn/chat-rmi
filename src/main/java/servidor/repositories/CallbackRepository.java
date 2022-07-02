/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.repositories;

import cliente.IClienteCallback;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import shared.models.Conversa;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public class CallbackRepository implements ICallbackRepository {
    private final List<IClienteCallback> _clienteCallbacks;
    
    public CallbackRepository(){
        _clienteCallbacks = new ArrayList<>();
    }

    @Override
    public void Add(IClienteCallback callback) {
        _clienteCallbacks.add(callback);
    }

    @Override
    public void Remove(IClienteCallback callback) {
        _clienteCallbacks.remove(callback);
    }

    @Override
    public List<IClienteCallback> GetAll() {
        return _clienteCallbacks;
    }

    @Override
    public List<IClienteCallback> GetByConversa(Conversa conversa) {
        var usuarios = conversa.GetUsuarios();
        List<String> nomesUsuarios = usuarios.stream().map(u -> u.GetName()).collect(Collectors.toList());
        
        var callbacks = new ArrayList<IClienteCallback>();
        
        for(IClienteCallback callback: _clienteCallbacks){
            try {
                var name = callback.GetUsuarioName();
                
                if(nomesUsuarios.contains(name)){
                    callbacks.add(callback);
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(CallbackRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return callbacks;
    }

    @Override
    public IClienteCallback GetByUsuario(Usuario usuario) {
        
        var callback = _clienteCallbacks.stream().filter(
                c -> {
                    try {
                        return c.GetUsuarioName().equals(usuario.GetName());
                    } catch (RemoteException ex) {
                        Logger.getLogger(CallbackRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return false;
                }
        ).findFirst().orElse(null);
    
        return callback;
    }
    
    
}
