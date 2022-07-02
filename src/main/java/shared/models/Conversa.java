/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandr
 */
public class Conversa {
    private List<Usuario> _usuarios;
    private List<Mensagem> _mensagens;
    
    public Conversa(List<Usuario> usuarios){
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
}
