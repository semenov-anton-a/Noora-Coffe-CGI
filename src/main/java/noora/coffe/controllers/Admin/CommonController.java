package noora.coffe.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class CommonController {

    @ModelAttribute("browserTitle")
    public String browserTitle(){ return  new String("Noora Coffe | Admin Page"); }

}
