package psv; 

import java.sql.*; 
import java.util.*; 

public class Teste { 
    public static void main(String[] args) { 
        Connection con = Conexao.abrirConexao();
        
        PessoaBean cb = new PessoaBean();
        PessoaDAO cd = new PessoaDAO(con);
        
       //Inserir
        /*
            cb.setCpf("125.266.195-48");
            cb.setNome("Heitor"); 
            cb.setSobrenome("Machado"); 
            cb.setIdade("21");
            cb.setEmail("EoMachas@gmail.com");
            cb.setRg("85.054.837-7");
            cb.setEndereco("Rua Machado de Assis");
            cb.setComplemento("");
            cb.setCep("08646-058");
            cb.setTelefone("(11) 05646-0543");
            cb.setSexo("Masculino");
            cb.setNacionalidade("Australiano");
            System.out.println(cd.inserir(cb));
        */
            
        //Alterar
            
            cb.setCpf("125.266.195-48");
            cb.setNome("Heitor"); 
            cb.setSobrenome("Machado"); 
            cb.setIdade("21");
            cb.setEmail("EoMachas@gmail.com");
            cb.setRg("85.054.837-7");
            cb.setEndereco("Rua Lenhas");
            cb.setComplemento("");
            cb.setCep("08646-058");
            cb.setTelefone("(11) 05646-0543");
            cb.setSexo("Masculino");
            cb.setNacionalidade("Australiano");
            System.out.println(cd.alterar(cb));
            
                
        //Excluir
        /*
            cb.setCpf("125.266.195-48");
            System.out.println(cd.excluir(cb));
        */
        
        //Listagem
        /*
            List<PessoaBean> lista = cd.listarTodos(); 
                if(lista != null){             
                    for(PessoaBean pessoa : lista){ 
                        System.out.println("Cpf: "+pessoa.getCpf()); 
                        System.out.println("Nome: "+pessoa.getNome()); 
                        System.out.println("Sobrenome: "+pessoa.getSobrenome());
                        System.out.println("Idade: "+pessoa.getIdade()); 
                        System.out.println("Email: "+pessoa.getEmail()); 
                        System.out.println("Rg: "+pessoa.getRg());
                        System.out.println("Endereço: "+pessoa.getEndereco()); 
                        System.out.println("Complemento: "+pessoa.getComplemento()); 
                        System.out.println("Cep: "+pessoa.getCep());
                        System.out.println("Telefone: "+pessoa.getTelefone()); 
                        System.out.println("Sexo: "+pessoa.getSexo()); 
                        System.out.println("Nacionalidade: "+pessoa.getNacionalidade());
                    }
                }
            Conexao.fecharConexao(con);
        */
    }    
} 