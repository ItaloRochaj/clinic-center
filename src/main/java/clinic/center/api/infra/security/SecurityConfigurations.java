package clinic.center.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Corrigido para usar o novo estilo de configuração
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Corrigido para usar o novo estilo de configuração

        return http.build();
    }

    //@Autowired
    //private SecurityFilter securityFilter;
    //
    //@Bean
    //public SecurityFilterChain (HttpSecurity http) throws Exception {
    //    return http.csrf().disable()
    //            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //            .and().authorizeHttpRequests()
    //            .requestMatchers(HttpMethod.POST, "/login").permitAll()
    //            .anyRequest().authenticated()
    //            .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
    //            .build();
    //} Esta depreciado!//



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}