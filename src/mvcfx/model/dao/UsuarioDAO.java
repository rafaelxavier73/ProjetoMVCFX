package mvcfx.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mvcfx.model.database.ConnectionFactory;
import mvcfx.model.domain.Usuario;

public class UsuarioDAO { 
    
    public Usuario loginUser(String login, String senha){
        
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = md5(?)";
        Usuario usuario = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = ConnectionFactory.getConnection().prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            while(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
            }

            rs.close();
            pst.close();
        } catch(SQLException ex){
            System.out.println(ex);
        }
        
        return usuario;
        
    }
    
    // pesquisar por nome
    public Usuario findbyNome(String nome){
        String sql = "SELECT * FROM usuario WHERE login LIKE ?";
        
        Usuario usuario = new Usuario();
        usuario.setLogin("");
        usuario.setEmail("");
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = ConnectionFactory.getConnection().prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            while(rs.next()){
                usuario.setLogin(rs.getString("login"));
                usuario.setEmail(rs.getString("email"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return usuario;
    }
    
    
    public boolean updatePassword(String login, String senha){
        
        String sql = "UPDATE usuario SET senha = md5(?) WHERE login LIKE ?";
        
        PreparedStatement pst;
        try {
            pst = ConnectionFactory.getConnection().prepareStatement(sql);
            pst.setString(1, senha);
            pst.setString(2, login);
            pst.execute();
            pst.close();  
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                      
        
    }
    
    

}
