package noora.coffe.controllers.Public;

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
public class PublicCommon  extends CommonControllerAdvice implements CommonInterface{
    
    
    private final String type = "public";

    public CommonInterface setModelAttributes( Model model ) {
        model.addAttribute( "browserTitle", "Noora Coffe" );
        model.addAttribute( "showBuyButton", true );
        return this;
    }






}
