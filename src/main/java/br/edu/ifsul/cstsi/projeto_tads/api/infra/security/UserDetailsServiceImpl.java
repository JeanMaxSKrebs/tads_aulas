package br.edu.ifsul.cstsi.projeto_tads.api.infra.security;

import br.edu.ifsul.cstsi.projeto_tads.api.model.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRep.findByLogin(username);
    }

//    //Implementação para fornecer os users em memória
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if(username.equals("user")){
//            return User.withUsername(username).password(encoder.encode("123")).roles("USER").build();
//        }else if(username.equals("admin")){
//            return User.withUsername(username).password(encoder.encode("123")).roles("USER", "ADMIN").build();
//        }
//        throw new UsernameNotFoundException("Usuario inexistente.");
//    }

//    //Utilizado para pegar o encode da senha e salvar na tabela User
//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123"));
//    }

}
