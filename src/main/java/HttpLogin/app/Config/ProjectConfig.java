package HttpLogin.app.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import HttpLogin.app.Service.AuthenticationProviderService;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private AuthenticationProviderService AuthenticationProviderService;
	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	 return new BCryptPasswordEncoder();
	 }
	 @Bean
	 public SCryptPasswordEncoder sCryptPasswordEncoder() {
	 return new SCryptPasswordEncoder();
	 }
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) {
	 auth.authenticationProvider(AuthenticationProviderService);
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http)
	  throws Exception {
	  http.formLogin().defaultSuccessUrl("/hello", true);
	  http.authorizeRequests().anyRequest().authenticated();
	 }
}
