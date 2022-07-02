/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import shared.models.Conversa;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public interface IClienteCallback extends Remote {
    public String GetUsuarioName() throws RemoteException;
    public void UpdateConversa(Conversa conversa) throws RemoteException;
    public void SetConversas(List<Conversa> conversas) throws RemoteException;
    public void SetUsuarios(List<Usuario> usuarios) throws RemoteException;
}
