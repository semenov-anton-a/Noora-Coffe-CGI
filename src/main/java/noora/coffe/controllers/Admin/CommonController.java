package noora.coffe.controllers.Admin;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import noora.coffe.entity.Product;


@ControllerAdvice
public class CommonController {

    @ModelAttribute("browserTitle")
    public String browserTitle(){ return  new String("Noora Coffe | Admin Page"); }





    protected int itemsCoutOfPage = 4;
    protected CommonController productPageable(
        Model model,  
        Page<Product> productList, 
        Integer pageNum,
        String url 
    ){
        int pageB = 0;
        pageB = ( productList.hasPrevious() ) ? pageNum - 1 : -1;

        int pageN = 0;
        pageN = (productList.hasNext() ) ? pageNum + 1 : -1;

        model.addAttribute("pageBack", pageB);
        model.addAttribute("pageNext", pageN);

        return  this.showPaginations( model, true, "/admin/"+url );
    }
    protected CommonController showPaginations(Model model, boolean pagination, String url) {
        model.addAttribute("pagination", pagination);
        model.addAttribute("paginationUri", url);
        return this;
    }
}
