package noora.coffe.controllers.Public;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.repos.*;
import noora.coffe.controllers.CommonControllerAdvice;
import noora.coffe.entity.*;
import noora.coffe.services.*;


@Controller
public class PublicIndexController extends PublicCommon{
    
    
    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProductService productService;
    
    @Autowired
    SupplierService supplierService;
    
    @Autowired
    MakerService makerService;

    @Autowired
    ShoppingCart shoppingCart;

    private String thisType;


    @Autowired
    HttpSession httpSession;
 

    @GetMapping("/")
    public String getPublicIndex( 
        Model model, 
        @RequestParam(defaultValue = "0") Integer page
    ){
        new PublicCommon().setModelAttributes( model );
        
        
        model.addAttribute( "countProductInAcard", shoppingCart.getIterator() );
        
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getAllWhereActive(true, pageable );
        
        super.productPageable(model, productList, page, "");
        model.addAttribute("productList", productList);
        
        model.addAttribute(
            "productDetailsLink", 
            this.getProductLinkDetailsLink( super.getType() )) ;

        return "public/index";
    }



    @PostMapping("/addproduct/{id}")
    public String addProductToCard( @PathVariable Long id ){
        Product product = productService.getProductByID(id);

        shoppingCart.addToCart(product);
        
        // System.out.println("========================");
        // System.out.println( product );
        // System.out.println("========================");
        
        return getPublicTemplateRedirect("");
    }


}
