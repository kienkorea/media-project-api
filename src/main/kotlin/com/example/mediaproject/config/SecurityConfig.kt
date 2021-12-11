package com.example.mediaproject.config

import com.example.mediaproject.common.filter.JwtAuthorizationFilter
import com.example.mediaproject.common.service.CustomUserDetailService
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@EnableWebSecurity
class SecurityConfig(
    private val userRepository: UserRepository,
    private val customUserDetailService: CustomUserDetailService,
    ): WebSecurityConfigurerAdapter() {

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        return DaoAuthenticationProvider().apply {
            setPasswordEncoder(BCryptPasswordEncoder())
            setUserDetailsService(customUserDetailService)
        }
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(JwtAuthorizationFilter(authenticationManager = authenticationManager(), userRepository = userRepository))
            .authorizeRequests{ request ->
                request.antMatchers("/media-project/up-down/accounts/**").permitAll()
                request.antMatchers("/media-project/up-down/stocks/**").permitAll()
                request.antMatchers("/media-project/up-down/board/list").permitAll()
//                request.anyRequest().authenticated()
            }
            .cors().and()
    }

}