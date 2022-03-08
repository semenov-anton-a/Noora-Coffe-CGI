package noora.coffe.services;

import org.springframework.stereotype.Service;

@Service
public class UserRolesService {
    

    public enum Roles {
        
        ADMIN("ADMIN"),
        CLIENT("CLIENT");

        public final String label;
    
        private Roles(String label) {
            this.label = label;
        }
    }


}
