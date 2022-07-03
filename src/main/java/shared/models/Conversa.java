/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author sandr
 */
public class Conversa implements Serializable {
    private List<Usuario> _usuarios;
    private List<Mensagem> _mensagens;
    private String _nome;
    private String _id;
    
    public Conversa(String nome, List<Usuario> usuarios){
        _id = UUID.randomUUID().toString();
        _nome = nome;
        _usuarios = usuarios;
        _mensagens = new ArrayList();
    }
    
    public void AddMensagem(Mensagem mensagem){
        _mensagens.add(mensagem);
    }
    
    public List<Usuario> GetUsuarios(){
        return _usuarios;
    }
    
    public List<Mensagem> GetMensagens(){
        return _mensagens;
    }
    
    public boolean ContemUsuario(Usuario usuario){
        return _usuarios.stream().anyMatch(u -> u.GetName().equals(usuario.GetName()));
    }
    
    public String GetNome(){
        return _nome;
    }

    public String GetId(){
        return _id;
    }
}
