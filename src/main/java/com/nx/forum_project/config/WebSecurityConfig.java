package com.nx.forum_project.config;

import com.nx.forum_project.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.nx.forum_project.security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImpl authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authProvider);

//        auth
//                .inMemoryAuthentication()
//                .withUser(adminLogin)
//                .password(passwordEncoder().encode(adminPassword))
//                .roles("ADMIN")
//                .and()
//                .withUser(userLogin)
//                .password(passwordEncoder().encode(userPassword))
//                .roles("USER");

//        auth
//                .inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/registration-form", "/registration-info").anonymous()
                .antMatchers("/ui/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .usernameParameter("login")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/")
                .and()
                .logout()
                .deleteCookies("JSESSIONID");

        http.headers().frameOptions().disable();//fix to use h2-console
        ;

        /*http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
//                .antMatchers("/users/create","/orders/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/autos/**","/ui/autos/**").hasAnyRole("ADMIN")
//                .antMatchers("/users/**","/projects/**","/tasks/**","/mvc-users/**","/mvc-projects/**","/mvc-tasks/**").hasAnyRole("ADMIN","MANAGER","QA","DEVELOPER","USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .permitAll();
*/

    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
