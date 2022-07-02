/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controllers;

import cliente.IClienteCallback;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.repositories.ICallbackRepository;
import shared.models.Usuario;
import servidor.views.ServidorView;
import servidor.repositories.IUsuariosRepository;
import servidor.services.IEncryptService;

/**
 *
 * @author sandr
 */
public class UsuariosController extends UnicastRemoteObject implements IUsuariosController {

    private final IUsuariosRepository _usuarioRepository;
    private final IEncryptService _encryptService;
    private final ServidorView _servidorView;
    private final ICallbackRepository _callbackRepository;
    
    public UsuariosController(
            IUsuariosRepository usuarioRepository, 
            IEncryptService encryptService,
            ICallbackRepository callbackRepository,
            ServidorView servidorView) throws RemoteException {
        super();
        _usuarioRepository = usuarioRepository;
        _encryptService = encryptService;
        _servidorView = servidorView;
        _callbackRepository = callbackRepository;
    }

    @Override
    public void Cadastrar(String nome, String senha) throws RemoteException, Exception {
        
        Usuario usuario = _usuarioRepository.GetByName(nome);
        
        if(usuario != null){
            throw new Exception("O nome já está em uso");
        }
        
        var senhaCriptografada = _encryptService.Criptografar(senha);
        
        usuario = new Usuario(nome, senhaCriptografada);
        
        _usuarioRepository.Add(usuario);
        _servidorView.UpdateUsuarios(_usuarioRepository.GetAll());    
    }

    @Override
    public void Entrar(String nome, String senha, IClienteCallback clienteCallback) throws RemoteException, Exception {
        Usuario usuario = _usuarioRepository.GetByName(nome);
        
        if(usuario == null){
            throw new Exception("Usuário não encontrado");
        }
        
        var senhaValida = _encryptService.Verificar(senha, usuario.GetSenhaCriptografada());
        
        if(!senhaValida){
            throw new Exception("Senha inválida");
        }
        
        usuario.Entrar();
        
        var usuariosOnline = _usuarioRepository.GetOnlines();
        _servidorView.UpdateUsuariosOnline(usuariosOnline);
        _callbackRepository.Add(clienteCallback);
        
        UpdateUsuariosOnCallbacks();
        
    }

    private void UpdateUsuariosOnCallbacks(){
        var usuarios = _usuarioRepository.GetAll();

        for(IClienteCallback clienteCallback: _callbackRepository.GetAll()){
            try {
                clienteCallback.SetUsuarios(usuarios);
            } catch (RemoteException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void Sair(String nome, IClienteCallback clienteCallback) throws RemoteException, Exception {
        Usuario usuario = _usuarioRepository.GetByName(nome);
        
        usuario.Sair();

        var usuariosOnline = _usuarioRepository.GetOnlines();
        _servidorView.UpdateUsuariosOnline(usuariosOnline);
        
        _callbackRepository.Remove(clienteCallback);
        UpdateUsuariosOnCallbacks();
    }
}
