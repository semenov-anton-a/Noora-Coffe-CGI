package noora.coffe.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import noora.coffe.CoffeApplication;
import noora.coffe.entity.Product;


@ControllerAdvice
public class CommonControllerAdvice {

    @ModelAttribute("browserTitle")
    public String browserTitleAdmin(){ return  new String("Noora Coffe | Admin Page"); }
    
    @ModelAttribute("browserTitle")
    public String browserTitlePublic(){ return  new String("Noora Coffe"); }

    @ModelAttribute("appversion")
    public String appVersion(){ return CoffeApplication.getAppVersion(); }


    protected static String getPublicTemplate( String template ){ return "public/"+template; }
    protected static String getPublicTemplateRedirect( String template ){ return "redirect:/"+template; }


    public String getProductLinkDetailsLink( String type ){
        String str = "";
        switch( type ){
            case "admin"  : str="admin/product";
            case "public" : str="product";
        }

        return str;
    }


    public int itemsCoutOfPage = 4;
    public CommonControllerAdvice productPageable(
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
    protected CommonControllerAdvice showPaginations(Model model, boolean pagination, String url) {
        model.addAttribute("pagination", pagination);
        model.addAttribute("paginationUri", url);
        return this;
    }
}
