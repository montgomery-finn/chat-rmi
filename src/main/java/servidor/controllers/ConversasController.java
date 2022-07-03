/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controllers;

import cliente.IClienteCallback;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import servidor.repositories.ICallbackRepository;
import servidor.repositories.IConversasRepository;
import servidor.repositories.IUsuariosRepository;
import shared.models.Conversa;
import shared.models.Mensagem;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public class ConversasController extends UnicastRemoteObject implements IConversasController {

    private IConversasRepository _conversasRepository;
    private IUsuariosRepository _usuariosRepository;
    private ICallbackRepository _callbackRepository;
    
    public ConversasController(IConversasRepository conversasRepository,
            IUsuariosRepository usuariosRepository,
            ICallbackRepository callbackRepository) throws RemoteException{
        super();
        _conversasRepository = conversasRepository;
        _usuariosRepository = usuariosRepository;
        _callbackRepository = callbackRepository;
    }
    
    @Override
    public void Create(String nome, List<String> nomesUsuarios) throws RemoteException, Exception, Exception {
        
        var usuarios = new ArrayList<Usuario>();
        Usuario usuario;
        
        for(var nomeUsuario: nomesUsuarios){
            usuario = _usuariosRepository.GetByName(nomeUsuario);
            usuarios.add(usuario);
        }
        
        var conversa = new Conversa(nome, usuarios);
        _conversasRepository.Add(conversa);
        
        UpdateConversasNosClientes(usuarios);
    
    }
    
    private void UpdateConversasNosClientes(List<Usuario> usuarios){
        
        IClienteCallback callback;
        List<Conversa> conversas;
        List<String> nomesConversas;
        
        for(var usuario : usuarios){
            callback = _callbackRepository.GetByUsuario(usuario);
            
            if(callback != null){
                conversas = _conversasRepository.ObterTodasUsuario(usuario);
                
                try {
                    callback.SetConversas(conversas);
                } catch (RemoteException ex) {
                    Logger.getLogger(ConversasController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void AddMensagem(String conversaId, String mensagem, String nomeUsuario) throws RemoteException, Exception, Exception {
        var conversa = _conversasRepository.GetById(conversaId);
        
        if(conversa == null){
            throw new Exception("conversa não encontrada");
        }
        
        Usuario usuario = _usuariosRepository.GetByName(nomeUsuario);
        
        conversa.AddMensagem(new Mensagem(mensagem, usuario));
        
        var callbacks = _callbackRepository.GetByConversa(conversa);
        
        List<Conversa> conversas;
        for(var callback : callbacks){
            usuario = _usuariosRepository.GetByName(callback.GetUsuarioName());
            conversas = _conversasRepository.ObterTodasUsuario(usuario);
            callback.SetConversas(conversas);
        }
    }
    
}
