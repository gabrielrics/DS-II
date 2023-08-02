package psv;

import java.sql.*;
import java.util.*;

public class PessoaDAO {
    private Connection con;
    
    public PessoaDAO(Connection con){
        setCon(con);
    }
    
    public Connection getCon(){
        return con;
    }
    
    public void setCon(Connection con){
        this.con = con;
    }
    
    public String inserir(PessoaBean pessoa){
        String sql = "insert into pessoa(cpf, nome, sobrenome, idade, email, rg, "
                + "endereco, complemento, cep, telefone, sexo, nacionalidade) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getSobrenome());
            ps.setString(4, pessoa.getIdade());
            ps.setString(5, pessoa.getEmail());
            ps.setString(6, pessoa.getRg());
            ps.setString(7, pessoa.getEndereco());
            ps.setString(8, pessoa.getComplemento());
            ps.setString(9, pessoa.getCep());
            ps.setString(10, pessoa.getTelefone());
            ps.setString(11, pessoa.getSexo());
            ps.setString(12, pessoa.getNacionalidade());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com sucexo.";
            }else{
                return "Erro ao inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public String alterar(PessoaBean pessoa){
        String sql = "update pessoa set nome = ?,sobrenome = ?,idade = ?,email = ?,rg = ?,"
                + "endereco = ?,complemento = ?,cep = ?,telefone = ?,sexo = ?,nacionalidade = ?"; 
        sql += " where cpf = ?"; 
        try { 
            PreparedStatement ps = getCon().prepareStatement(sql); 
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSobrenome());
            ps.setString(3, pessoa.getIdade());
            ps.setString(4, pessoa.getEmail());
            ps.setString(5, pessoa.getRg());
            ps.setString(6, pessoa.getEndereco());
            ps.setString(7, pessoa.getComplemento());
            ps.setString(8, pessoa.getCep());
            ps.setString(9, pessoa.getTelefone());
            ps.setString(10, pessoa.getSexo());
            ps.setString(11, pessoa.getNacionalidade());
            ps.setString(12, pessoa.getCpf());

            if (ps.executeUpdate() > 0) { 
                return "Alterado com sucesso."; 
            } else { 
                return "Erro ao alterar"; 
            }
        } catch (SQLException e) { 
            return e.getMessage(); 
        }
    }
    
    public String excluir(PessoaBean pessoa){
        String sql = "delete from pessoa where cpf = ?";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pessoa.getCpf());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucexo.";
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<PessoaBean> listarTodos(){
        String sql = "select * from pessoa";
        List<PessoaBean> listaPessoa = new ArrayList<PessoaBean>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    PessoaBean cb = new PessoaBean(); 
                    cb.setCpf(rs.getString(1));
                    cb.setNome(rs.getString(2));
                    cb.setSobrenome(rs.getString(3));
                    cb.setIdade(rs.getString(4));
                    cb.setEmail(rs.getString(5));                    
                    cb.setRg(rs.getString(6));
                    cb.setEndereco(rs.getString(7));
                    cb.setComplemento(rs.getString(8));
                    cb.setCep(rs.getString(9));
                    cb.setTelefone(rs.getString(10));
                    cb.setSexo(rs.getString(11));
                    cb.setNacionalidade(rs.getString(12));
                    listaPessoa.add(cb);
                }
                
                return listaPessoa;
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }
}
