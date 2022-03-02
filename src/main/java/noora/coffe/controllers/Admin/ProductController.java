package noora.coffe.controllers.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

@Controller
public class ProductController extends CommonController{


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


    @GetMapping("/admin/products")
    public String getProduct(Model model, @RequestParam(defaultValue = "0") Integer page) {

        model.addAttribute( "depList", departmentService.getList() );
        model.addAttribute( "supList", supplierService.getList() );
        model.addAttribute( "makerList", makerService.getList() );

        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getAll( pageable );
        
        super.productPageable(model, productList, page, "products");
        model.addAttribute("productList", productList);

        return "admin/products";
    }

    /**
     * Update product category
     * 
     * @POST
     * @param department
     * @return
     */
    @PostMapping(
        path = "/admin/product", 
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String updateProduct( Product product ){
        productService.addProduct(product);

        // System.out.println("========================");
        // System.out.println( product.getMaker() );
        // System.out.println( product.getSupplier() );
        // System.out.println( product.getDepartment() );
        // System.out.println("========================");
        return "redirect:/admin/products";
    }

}
