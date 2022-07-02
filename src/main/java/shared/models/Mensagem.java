/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared.models;

import java.time.LocalDateTime;

/**
 *
 * @author sandr
 */
public class Mensagem {
    private String _text;
    private LocalDateTime _createdAt;
    
    public String GetText(){
        return _text;
    }
    
    public Mensagem(String text){
        _text = text;
        _createdAt = LocalDateTime.now();
    }
}
