/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author sandr
 */
public interface IConversasController extends Remote{
    public void Create(String nome, List<String> nomesUsuarios) throws RemoteException, Exception, Exception;
    public void AddMensagem(String conversaId, String mensagem, String nomeUsuario) throws RemoteException, Exception, Exception;
}
