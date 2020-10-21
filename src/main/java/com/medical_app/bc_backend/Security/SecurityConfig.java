package com.medical_app.bc_backend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.medical_app.bc_backend.Security.Filter.JwtRequestFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(usuarioDetailsService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()


			// Health Check
		
			.antMatchers(
					"/",
					"/healthCheck/**"
					).permitAll()
			
			// Autorização POST para autenticação
		
		    .antMatchers(HttpMethod.POST, 
		    		"/authenticate"
		    		).permitAll()
		   
		    .antMatchers(HttpMethod.GET, 
		    		"/consulta/**", 
		    		"/usuario/**", 
		    		"/tipo_usuario/**"
		    		).permitAll()
	    
		    // Autorização READ MR
	/*	    
		    .antMatchers(HttpMethod.POST, 
		    		"/consulta/**"
		    		).hasAuthority("Paciente")
		    
		    .antMatchers(HttpMethod.GET, 
		    		"/consulta/**", 
		    		"/usuario/**", 
		    		"/tipo_usuario/**"
		    		).hasAnyAuthority("Médico","Paciente")
	    
		    // Autorização UC PR 
		    
		    .antMatchers(HttpMethod.POST, 
		    		"/grupo_tarefa/**",
		    		"/integrante_grupo_tarefa/**"
		    		).hasAnyAuthority("PR","SI")
		    .antMatchers(HttpMethod.PUT, 
		    		"/grupo_tarefa/**",
		    		"/integrante_grupo_tarefa/**"
		    		).hasAnyAuthority("PR","SI")
		    
		    // Autorização UC MR
		    
		    .antMatchers(HttpMethod.POST, 
		    		"/dia_marinheiro/**",
		    		"/evidencia_tarefa/**"
		    		).hasAnyAuthority("MR","SI")
    		.antMatchers(HttpMethod.PUT, 
		    		"/dia_marinheiro/**",
		    		"/evidencia_tarefa/**"
		    		).hasAnyAuthority("MR","SI")

		    		
		    // Autorização READ PR e MR
		    
		    .antMatchers(HttpMethod.GET, 
		    		"/dia_marinheiro/**",
		    		"/embarcacao/**",
		    		"/estado_federação/**",
		    		"/municipio/**",
		    		"/dia_semana/**",
		    		"/embarcacao_marinheiro/**",
		    		"/estado_tarefa/**",
		    		"/grandeza/**",
		    		"/modelo_tarefa/**",
		    		"/unidade_medida/**",
		    		"/usuario/**"
		    		).hasAnyAuthority("PR","MR","SI")
		    
		    // Autorização UC PR e MR
		    
		    .antMatchers(HttpMethod.POST, 
		    		"/atributo_equipamento/**",
		    		"/complemento_tarefa_generica/**",
		    		"/etapa_tarefa/**",
		    		"/interdicao_ambiente/**",
		    		"/interdicao_equipamento/**",
		    		"/marinheiro_escalado/**",
		    		"/usuario_etapa_tarefa_vista/**"
		    		).hasAnyAuthority("PR","MR","SI")
    		.antMatchers(HttpMethod.PUT, 
    				"/atributo_equipamento/**",
		    		"/complemento_tarefa_generica/**",
		    		"/etapa_tarefa/**",
		    		"/interdicao_ambiente/**",
		    		"/interdicao_equipamento/**",
		    		"/marinheiro_escalado/**",
		    		"/usuario_etapa_tarefa_vista/**"
		    		).hasAnyAuthority("PR","MR","SI")
		    
		    // Autorização CRU PR e MR
		    
		    .antMatchers(HttpMethod.GET, 
		    		"/equipamento/**",
		    		"/tarefa/**",
		    		"/beacon_usuario/**",
		    		"/informacoes_sensiveis/**"
		    		).hasAnyAuthority("PR","MR","SI")    
    		.antMatchers(HttpMethod.POST, 
		    		"/equipamento/**",
		    		"/tarefa/**",
		    		"/beacon_usuario/**",
		    		"/informacoes_sensiveis/**"
		    		).hasAnyAuthority("PR","MR","SI")
    		.antMatchers(HttpMethod.PUT, 
		    		"/equipamento/**",
		    		"/tarefa/**",
		    		"/beacon_usuario/**",
		    		"/informacoes_sensiveis/**"
		    		).hasAnyAuthority("PR","MR","SI")
			
			// Autorização SI
    		
    		.antMatchers(HttpMethod.GET, 
		    		"/**"
		    		).hasAnyAuthority("PR","MR","SI")    
			
    		.antMatchers(HttpMethod.POST, 
		    		"/**"
		    		).hasAnyAuthority("SI")
    		
			.anyRequest().hasAuthority("SI")
*/			
		    .anyRequest().permitAll()
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
}