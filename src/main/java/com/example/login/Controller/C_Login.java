package com.example.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Login {
    @GetMapping("/")
    public String landLogin(){
        return "Login/login";
    }

    @PostMapping("/")
    public String getLogin(@RequestParam("user") String usuario,
                           @RequestParam("senha") String senha){
        String validUser = "Lucas";
        String validPassword = "123456";
        if(usuario.equals(validUser) && senha.equals(validPassword)){
            return "Home/home";
        }else{
            return "Login/login";
        }

    }
}
