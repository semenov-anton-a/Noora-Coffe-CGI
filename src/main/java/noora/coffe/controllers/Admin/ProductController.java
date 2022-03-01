package noora.coffe.controllers.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
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
    

    @GetMapping("/admin/products")
    public String getProduct(){

        // model.addAttribute( "browserTitle" , "asd" ); 

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
    public String updateProduct(
            // @RequestParam Long id,
            Product product,
            @RequestParam Long depid,


            // FORM OPTION 
            @RequestParam String option
    ){


        System.out.println("========================");
        System.out.println( product.getName() );
        System.out.println( depid );
        System.out.println("========================");
        return "redirect:/admin";

        
        // switch( option )
        // {
        //     case "add" :
        //         if (product.getName().equals("")) { return "redirect:/admin"; }
        //         productService.addNewProduct(product, departmentID);
        //         break;
        //     case "update" : 
        //         productService.updateProductDepartment( product.getId(), departmentID);  
        //         break;
        //     case "delete" :
        //         productService.deleteById( product.getId() ); 
        //         break;
        // }

        // return "redirect:/admin";
    }

}
