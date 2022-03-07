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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.controllers.CommonControllerAdvice;
import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

@Controller
public class AdminProductController extends CommonControllerAdvice{


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
     * 
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/product/{id}")
    public String getProductByID( Model model, @PathVariable Long id ) {
        
        Product product = productService.getProductByID( id );
        System.out.println("========================");
        // System.out.println( product.getDepartment().getId() );
        // System.out.println( product.getDepartment().notNullValue() );
        System.out.println("========================");



        model.addAttribute( "depList", departmentService.getList() );
        model.addAttribute( "supList", supplierService.getList() );
        model.addAttribute( "makerList", makerService.getList() );
        model.addAttribute( "product", product );

        return "admin/product-details";
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


    /**
     * Update product category
     * 
     * @POST
     * @param department
     * @return
     */
    @PostMapping(
        path = "/admin/product/edit/{id}", 
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String editProduct( Product product, @RequestParam String option){
        
        switch( option )
        {
            case "remove" : productService.removeProduct(product) ;
                break;
            case "update": productService.updateProduct(product);
                break;
        }
        // productService.addProduct(product);
        // productService.updateProduct(product);
        
        System.out.println("========================");
        System.out.println( option );
        // System.out.println( product.getMaker() );
        // System.out.println( product.getSupplier() );
        // System.out.println( product.getDepartment() );
        System.out.println("========================");
        return "redirect:/admin/products";
    }

}
