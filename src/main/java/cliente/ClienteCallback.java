/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import shared.models.Conversa;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public class ClienteCallback extends UnicastRemoteObject implements IClienteCallback {

    private String _usuarioName;
    
    private List<Conversa> _conversas;
    
    private List<Usuario> _usuarios;
    
    private ClienteView _clienteView;
    
    public ClienteCallback(ClienteView clienteView, String usuarioName) throws RemoteException {
        super();
        _clienteView = clienteView;
        _usuarioName = usuarioName;
    }
    
    @Override
    public void UpdateConversa(Conversa conversa) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SetConversas(List<Conversa> conversas) throws RemoteException {
        _clienteView.UpdateConversas(conversas);
    }

    @Override
    public void SetUsuarios(List<Usuario> usuarios) throws RemoteException {
        _clienteView.UpdateUsuarios(usuarios);
    }

    @Override
    public String GetUsuarioName() throws RemoteException {
        return _usuarioName;
    }
    
}
