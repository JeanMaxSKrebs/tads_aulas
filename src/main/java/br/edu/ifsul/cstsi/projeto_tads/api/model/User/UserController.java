package br.edu.ifsul.cstsi.projeto_tads.api.model.User;


import br.edu.ifsul.cstsi.projeto_tads.api.infra.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    public UserDTO userInfo(@AuthenticationPrincipal User user) { //a anotação retorna o user logado

        //User userLoged = (User) JwtUtil.getUserDetails(); //outra forma de retornar o user logado (nesse projeto)

        return UserDTO.create(user);
    }
}