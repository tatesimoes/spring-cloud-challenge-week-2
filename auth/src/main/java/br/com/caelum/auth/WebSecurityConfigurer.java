package br.com.caelum.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Override @Bean
	protected  AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	};
	
	@Override @Bean
	protected  UserDetailsService userDetailsService() {
		return super.userDetailsService();
	};
	
	@Bean
	public  PasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder();
	};

	
	@Override
	public void configure(AuthenticationManagerBuilder authentication) throws Exception {
		authentication.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder())
			.withUser("donos")
			.password(passwordEncoder().encode("userpass"))
			.roles("RESTAURANTE");
	}

}
