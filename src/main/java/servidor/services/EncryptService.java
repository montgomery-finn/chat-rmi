/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.services;

/**
 *
 * @author sandr
 */
public class EncryptService implements IEncryptService {

    @Override
    public String Criptografar(String senha) {
        return senha;
    }

    @Override
    public boolean Verificar(String senha, String criptografada) {
        return senha.equals(criptografada);
    }
    
}
