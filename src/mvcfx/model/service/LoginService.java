package mvcfx.model.service;

import mvcfx.model.domain.Usuario;
import mvcfx.model.dao.UsuarioDAO;
import mvcfx.model.database.ConnectionFactory;
import mvcfx.model.database.DatabaseMySQL;
import mvcfx.util.Session;

public class LoginService {
    
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;

    public void createConnection() {      
        ConnectionFactory.createDatabase(new DatabaseMySQL());
    }
     
    public boolean checkAccess(String login, String senha){
        return(usuarioDAO.loginUser(login, senha).getId()>0);            
    }
    
    public boolean checkUserbyName(String nomeUsuario){
        usuario = usuarioDAO.findbyNome(nomeUsuario);
        return usuario.getLogin().equals(nomeUsuario);
    }
    
    public void sendEmail() {
        Session.setUserName(usuario.getLogin());        
        System.out.println(generateRecoveryCode());        
    }
    
    private int generateRecoveryCode(){
        int recoveryCode = (int) (Math.random() * 1000000);
        Session.setRecoveryCode(recoveryCode); 
        return recoveryCode;
    }
    
    

}
