package noora.coffe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    

    @GetMapping("/login")
    public String viewLoginPage() {
            
        return "@auth/login";
    }



    @GetMapping("/registration")
    public String registrationPagre() {
            
        return "@auth/registration";
    }

}
