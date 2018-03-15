package ua.kiev.prog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        ReflectionSaltSource rss = new ReflectionSaltSource();
        rss.setUserPropertyToUse("salt");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setSaltSource(rss);
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(getShaPasswordEncoder());
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/cabinet").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/viewtd").hasRole("ADMIN")
                .antMatchers("/viewcustom").hasRole("ADMIN")
                .antMatchers("/viewcustom/{login}").hasRole("ADMIN")
                .antMatchers("/viewservices").hasRole("ADMIN")
                .antMatchers("/deleteservices").hasRole("ADMIN")
                .antMatchers("/addservice").hasRole("ADMIN")
                .antMatchers("/viewtakenservices").hasRole("ADMIN")
                .antMatchers("/sorttestdrive").hasRole("ADMIN")
                .antMatchers("/downloadFile/{action}").hasRole("ADMIN")
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/hello").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_login")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }

    private ShaPasswordEncoder getShaPasswordEncoder() {

        return new ShaPasswordEncoder(512);

    }
}
