/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.repositories;

import java.util.List;
import shared.models.Conversa;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public interface IConversasRepository {
    public void Add(Conversa conversa);
    public Conversa GetById(String id);
    public List<Conversa> ObterTodasUsuario(Usuario usuario);
}
