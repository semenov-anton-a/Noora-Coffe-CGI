package noora.coffe.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndexController {
    

    @GetMapping("/admin")
    public String getAdminIndex() {
        
        System.out.println( "**********************" );
        System.out.println( "ADMIN INDEX CONTROLLER" );
        
        return "admin/index";
    }



}
