/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.controllers.IUsuariosController;

/**
 *
 * @author sandr
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            IUsuariosController usuariosController = (IUsuariosController) Naming.lookup("rmi://localhost:1234/Usuarios");
            
            ClienteView cadastroView = new ClienteView(usuariosController);
            cadastroView.setVisible(true);
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
