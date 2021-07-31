package pers.yan.sblog.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pers.yan.sblog.security.filter.JwtFilter;
import pers.yan.sblog.security.handler.SblogAccessDeniedHandler;
import pers.yan.sblog.security.handler.SblogAuthenticationEntryPoint;

/**
 * @author likaiyan
 * @date 2021/7/23 11:22 上午
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(sBlogAccessDeniedHandler())
                .authenticationEntryPoint(sBlogAuthenticationEntryPoint())
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .csrf().disable();
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler sBlogAccessDeniedHandler() {
        return new SblogAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint sBlogAuthenticationEntryPoint() {
        return new SblogAuthenticationEntryPoint();
    }
}
