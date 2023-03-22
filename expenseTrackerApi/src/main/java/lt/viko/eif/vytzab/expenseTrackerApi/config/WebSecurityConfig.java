package lt.viko.eif.vytzab.expenseTrackerApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lt.viko.eif.vytzab.expenseTrackerApi.security.CustomUserDetailsService;
import lt.viko.eif.vytzab.expenseTrackerApi.security.JwtRequestFilter;

/**
 * @author Vytautas
 *
 *         Class for the web security configuration
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public JwtRequestFilter authenticationJwtTokenFilter() {
		return new JwtRequestFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/login", "/register").permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers(HttpMethod.POST, "/**").antMatchers(HttpMethod.OPTIONS, "/**").and()
				.ignoring().antMatchers(HttpMethod.GET, "/**").and().ignoring().antMatchers(HttpMethod.DELETE, "/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}