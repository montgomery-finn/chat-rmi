/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared.models;

import java.io.Serializable;

/**
 *
 * @author sandr
 */
public class Usuario implements Serializable {
    
    private String _name;
    private String _senhaCriptografada;
    private boolean _online;
    
    public Usuario(String name, String senhaCriptografada){
        _name = name;
        _senhaCriptografada = senhaCriptografada;
    }
    
    public String GetName(){
        return _name;
    }
    
    public boolean GetOnline(){
        return _online;
    }
    
    public String GetSenhaCriptografada(){
        return _senhaCriptografada;
    }
    
    public void Entrar(){
        _online = true;
    }
    
    public void Sair(){
        _online = false;
    }
}
