package mvcfx.model.service;

import mvcfx.model.dao.UsuarioDAO;

public class RecoveryService {
    
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public boolean updatePassword(String login, String senha){
        return usuarioDAO.updatePassword(login, senha);
    }

}
