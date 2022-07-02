/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.services;

/**
 *
 * @author sandr
 */
public interface IEncryptService {
    public String Criptografar(String senha);
    public boolean Verificar(String senha, String criptografada);
}
