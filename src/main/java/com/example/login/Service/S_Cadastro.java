package com.example.login.Service;

import com.example.login.Model.M_Pessoa;
import com.example.login.Repository.R_Pessoa;
import org.springframework.stereotype.Service;

@Service
public class S_Cadastro {
    private static R_Pessoa r_pessoa;

    public S_Cadastro(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static String validaCadastro(String nome, String email, String usuario,
                                 String senha, String conf_senha){
        String mensagem = "";
        boolean podeSalvar = true;
        if(!senha.equals(conf_senha) || senha == null || senha.trim().equals("")){
            mensagem += "Senha e confirmação de senha não conferem\n";
            podeSalvar = false;
        }
        if(nome == null || nome.trim().equals("")){
            mensagem += "O nome precisa ser preenchido\n";
            podeSalvar = false;
        }
        if(email == null || email.trim().equals("")){
            mensagem += "O e-Mail precisa ser preenchido\n";
            podeSalvar = false;
        }
        if(usuario == null || usuario.trim().equals("")){
            mensagem += "O Usuário precisa ser preenchido";
            podeSalvar = false;
        }

        if(podeSalvar){
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setEmail(email);
            m_pessoa.setUsuario(usuario);
            m_pessoa.setSenha(senha);
            r_pessoa.save(m_pessoa);
            mensagem += "Cadastro Salvo com Sucesso!";
        }

        return mensagem;
    }
}
