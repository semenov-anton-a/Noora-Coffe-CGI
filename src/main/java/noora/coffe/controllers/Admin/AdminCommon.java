package noora.coffe.controllers.Admin;

import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noora.coffe.controllers.CommonControllerAdvice;
import noora.coffe.controllers.CommonInterface;


@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
@Scope("prototype")
public class AdminCommon  extends CommonControllerAdvice implements CommonInterface{
    

    private final String type = "admin";

    public CommonInterface setModelAttributes( Model model ) {
        model.addAttribute( "browserTitle", "Noora Coffe | Admin Panel" );


        model.addAttribute( "showBuyButton", false );
        
        

        return this;
    }


}
