/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.controllers;

import cliente.IClienteCallback;
import java.rmi.Remote;
import java.rmi.RemoteException;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public interface IUsuariosController extends Remote {
    public void Cadastrar(String nome, String senha) throws RemoteException, Exception, Exception;
    public void Entrar(String nome, String senha, IClienteCallback clienteCallback) throws RemoteException, Exception;
    public void Sair(String nome, IClienteCallback clienteCallback) throws RemoteException, Exception;
}
