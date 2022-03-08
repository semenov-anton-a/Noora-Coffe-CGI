// package noora.coffe.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import noora.coffe.entity.*;
// import noora.coffe.repos.*;

// @Service
// public class UserService implements UserDetailsService{
    

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
//         User user = userRepository.findByEmail(email);

//         if( user == null ){
//             throw new UsernameNotFoundException( "User: " + email + " not found");
//         }
        

//         return new org.springframework.security.core.userdetails.User(email, email, false, false, false, false, null);
        
//     }




// }
