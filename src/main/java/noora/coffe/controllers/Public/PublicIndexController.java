package noora.coffe.controllers.Public;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.repos.*;
import noora.coffe.controllers.CommonControllerAdvice;
import noora.coffe.entity.*;
import noora.coffe.services.*;


@Controller
public class PublicIndexController extends CommonControllerAdvice{
    
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

    private String thisType;



 

    @GetMapping("/")
    public String getPublicIndex( Model model, @RequestParam(defaultValue = "0") Integer page ){

      
        model.addAttribute( "depList", departmentService.getList() );
        model.addAttribute( "supList", supplierService.getList() );
        model.addAttribute( "makerList", makerService.getList() );

        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getAll( pageable );
        
        super.productPageable(model, productList, page, "products");
        model.addAttribute("productList", productList);



        model.addAttribute("productDetailsLink", this.getProductLinkDetailsLink( new PublicCommon().getType() ) );

        return "public/index";
        // return getTemplate("index");
    }

}
