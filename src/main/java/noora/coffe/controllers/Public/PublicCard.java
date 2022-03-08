package noora.coffe.controllers.Public;

import java.math.BigDecimal;
import java.util.Map;

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
public class PublicCard  extends PublicCommon{
    
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

    @GetMapping("/card")
    public String getCard( Model model ){

        new PublicCommon().setModelAttributes( model );
        
        model.addAttribute( "countProductInAcard", shoppingCart.getIterator() );
        model.addAttribute( "browserTitle", "Noora Coffe | Card" );

        model.addAttribute( "productList", shoppingCart.getItems() );
        model.addAttribute( "productsTotalPrice", shoppingCart.getTotalPrice() );

        return "public/card";
    }
}
