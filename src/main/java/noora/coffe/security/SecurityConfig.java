// package noora.coffe.security;

// import javax.sql.DataSource;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
//     @Autowired
//     DataSource dataSource;
    
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception{    
//         //default schema to create users
//         auth.jdbcAuthentication()
//             .dataSource(dataSource);
//         // .usersByUsernameQuery("select username,password,enabled from users where username = ?")
//         // .authoritiesByUsernameQuery("select username,authority from authorities where username = ?");                
//     }    
//     @Bean
//     public PasswordEncoder getPasswordEncoder(){
//         return NoOpPasswordEncoder.getInstance();
//     }    
//     @Override
//     protected void configure(HttpSecurity http) throws Exception{
        
//         http.csrf().disable();
//         http.headers().frameOptions().sameOrigin();

//         http.authorizeRequests()
//             // .antMatchers("/accounts","/accounts/**").permitAll()
//             .antMatchers("/h2-console","/h2-console/**").permitAll()
//             .antMatchers("/admin","/admin/**").permitAll()//.hasRole("ADMIN")
//             .antMatchers("/**").permitAll()
//             .anyRequest().authenticated()
//             .and()
//                 .formLogin()
//                 .permitAll()
//             .and()
//                 .logout()
//                 .permitAll();
//     }
// }