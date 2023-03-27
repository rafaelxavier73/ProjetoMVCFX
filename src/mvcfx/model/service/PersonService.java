package mvcfx.model.service;

import mvcfx.model.dao.PessoaDAO;
import mvcfx.model.domain.Pessoa;

public class PersonService {
    
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private Pessoa pessoa;
    
    
    public boolean insertPerson(String nome, String cpf, String rg, String sexo, String endereco){
        pessoa = new Pessoa(nome, cpf, rg, sexo, endereco);
        return pessoaDAO.insert(pessoa);
    }

}
