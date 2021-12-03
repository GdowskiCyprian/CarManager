package com.engineer.carmanager.security;

import com.engineer.carmanager.services.iClientService;
import com.engineer.carmanager.services.iRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class CarManagerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("RepairShopService")
    iRepairShopService iRepairShopService;
    @Qualifier("ClientService")
    iClientService iClientService;
    @Autowired
    DataSource dataSource;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public CarManagerSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(this.dataSource)
                .usersByUsernameQuery(
                        "SELECT mail_address,password, true FROM auth WHERE mail_address = ?"
                )
                .authoritiesByUsernameQuery(
                        "SELECT mail_address, role FROM auth where mail_address = ?"
                );

    }
    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/repairshops/**").hasAuthority("REPAIR_SHOP")
                .antMatchers("/api/clients/**").hasAnyAuthority("CLIENT","REPAIR_SHOP")
                .antMatchers("/login/**").fullyAuthenticated()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();


    }
}
