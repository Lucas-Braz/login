package com.example.login.Controller;


import com.example.login.Service.S_Cadastro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {
    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("email") String email,
                               @RequestParam("usuario") String usuario,
                               @RequestParam("senha") String senha,
                               @RequestParam("confsenha") String conf_senha){
        String mensagem = S_Cadastro.validaCadastro(nome, email, usuario, senha, conf_senha);
        return "redirect:/";
    }
}
