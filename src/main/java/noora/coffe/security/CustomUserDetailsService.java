// package noora.coffe.security;



// import java.util.Arrays;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;


// import noora.coffe.repos.*;
// import noora.coffe.entity.*;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User account = userRepository.findByEmail(username);
        
//         if (account == null) {
//             throw new UsernameNotFoundException("No such user: " + username);
//         }

//         return new org.springframework.security.core.userdetails.User(
//                 account.getEmail(),
//                 account.getPassword(),
//                 true,
//                 true,
//                 true,
//                 true,
//                 Arrays.asList(new SimpleGrantedAuthority("USER")));
//     }
// }

