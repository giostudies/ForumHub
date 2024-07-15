package com.br.alura.forum.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Carregar o usuário do banco de dados
        // Exemplo básico:
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername("user")
                    .password(new BCryptPasswordEncoder().encode("password"))
                    .authorities("ROLE_USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
