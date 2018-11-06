package hus.k61a3.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    @Transactional
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
//                withUser("kai").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
//        Kai 123456  sena 123456
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
//        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ADMIN");

        // Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /user/**
//        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ADMIN') or hasRole('MEMBER')");
        http.authorizeRequests().antMatchers("/user/**","grim-warlock-11387.herokuapp.com").hasAnyAuthority("ADMIN", "MEMBER");

        // Khi người dùng đã login, với vai trò USER, Nhưng truy cập vào trang yêu cầu vai trò ADMIN, sẽ chuyển hướng tới trang /403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        //  Cấu hình remember me, thời gian là 1296000 giây
        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
//        http.rememberMe().authenticationSuccessHandler();

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                .loginProcessingUrl("/j_spring_security_login")//
                .loginPage("/login")//
                .defaultSuccessUrl("/user")//
                .failureUrl("/login?message=error")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
    }
}
