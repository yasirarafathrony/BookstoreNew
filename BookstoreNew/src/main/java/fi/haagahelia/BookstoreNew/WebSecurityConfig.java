package fi.haagahelia.BookstoreNew;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
	        .and()
	        .authorizeRequests().anyRequest().authenticated()
	        .and()
	      .formLogin()
	          .loginPage("/login")
	          .defaultSuccessUrl("/booklist")
	          .permitAll()
	          .and()
	      .logout()
	          .permitAll();
	    }
	 
	 
	 @Bean
	 @Override
	    public UserDetailsService userDetailsService() {
	        List<UserDetails> users = new ArrayList();
	    	

	    	
	    	
	        return new InMemoryUserDetailsManager(users);
	    }


	


	
	
	
}
