package mvcfx.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import mvcfx.model.domain.Pessoa;
import java.util.ArrayList;
import mvcfx.model.database.ConnectionFactory;

public class PessoaDAO implements GenericDAO<Pessoa>{

    @Override
    public boolean insert(Pessoa object) {
        String sql = "INSERT INTO pessoa (nome,cpf,rg,sexo,endereco) VALUES (?,?,?,?,?)";
        
            PreparedStatement pst;
            
            try {
                pst = ConnectionFactory.getConnection().prepareStatement(sql);
                pst.setString(1, object.getNome());
                pst.setString(2, object.getCpf());
                pst.setString(3, object.getRg());
                pst.setString(4, object.getSexo());
                pst.setString(5, object.getEndereco());
                pst.execute();
                pst.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                return false;
            } 
            
            return true;
    }

    @Override
    public boolean update(Pessoa object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pessoa> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa findbyFilter(Pessoa object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa getbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
