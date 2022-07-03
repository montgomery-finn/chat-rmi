/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sandr
 */
public class Mensagem implements Serializable {
    private String _text;
    private LocalDateTime _createdAt;
    private Usuario _usuario;
    
    public String GetText(){
        return _text;
    }
    
    public String GetTime(){
        return _createdAt.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    
    public String GetUsuarioName(){
        return _usuario.GetName();
    }
    
    public Mensagem(String text, Usuario usuario){
        _text = text;
        _createdAt = LocalDateTime.now();
        _usuario = usuario;
    }
}
