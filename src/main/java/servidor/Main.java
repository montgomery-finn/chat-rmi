/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import servidor.controllers.ConversasController;
import servidor.controllers.IConversasController;
import servidor.views.ServidorView;
import servidor.repositories.UsuariosRepository;
import servidor.controllers.UsuariosController;
import servidor.repositories.IUsuariosRepository;
import servidor.services.EncryptService;
import servidor.services.IEncryptService;
import servidor.controllers.IUsuariosController;
import servidor.repositories.CallbackRepository;
import servidor.repositories.ConversasRepository;
import servidor.repositories.ICallbackRepository;
import servidor.repositories.IConversasRepository;

/**
 *
 * @author sandr
 */
public class Main {
    public static void main(String[] args) throws RemoteException{
        
        ServidorView servidorView = new ServidorView();
        
        IUsuariosRepository usuarioRepository = new UsuariosRepository();
        ICallbackRepository callbackRepository = new CallbackRepository();
        IConversasRepository conversasRepository = new ConversasRepository();
        
        IEncryptService encryptService = new EncryptService();
        
        IUsuariosController usuariosController = 
                new UsuariosController(usuarioRepository, encryptService, callbackRepository, servidorView, conversasRepository);
        
        IConversasController conversasController = 
                new ConversasController(conversasRepository, usuarioRepository, callbackRepository);
        
        servidorView.setVisible(true);
        
        Registry registry = LocateRegistry.createRegistry(1234);
        registry.rebind("Usuarios", usuariosController);
        registry.rebind("Conversas", conversasController);
        
    }
}
