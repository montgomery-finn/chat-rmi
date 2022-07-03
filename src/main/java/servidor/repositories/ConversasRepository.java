/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.repositories;

import java.util.ArrayList;
import java.util.List;
import shared.models.Conversa;
import shared.models.Usuario;

/**
 *
 * @author sandr
 */
public class ConversasRepository implements IConversasRepository {
    private List<Conversa> _conversas;
    
    public ConversasRepository(){
        _conversas = new ArrayList<>();
    }

    @Override
    public void Add(Conversa conversa) {
        _conversas.add(conversa);
    }

    @Override
    public List<Conversa> ObterTodasUsuario(Usuario usuario) {
        var conversas = new ArrayList<Conversa>();
        
        for(var conversa : _conversas){
            if(conversa.ContemUsuario(usuario)){
                conversas.add(conversa);
            }
        }
        
        return conversas;
    }

    @Override
    public Conversa GetById(String id) {
        var conversa = _conversas.stream().filter(c -> c.GetId().equals(id)).findFirst().orElse(null);
        return conversa;
    }
}
