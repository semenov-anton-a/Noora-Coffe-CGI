package noora.coffe.controllers.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

@Controller
public class ProductController  {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProductService productService;


    /**
     * Add new product
     * 
     * @POST
     * @param department`
     * @return
     */
    @PostMapping(path = "/admin/add-product", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String addNewProduct(Product product, @RequestParam Long departmentID) {
        if (product.getName().equals("")) {
            return "redirect:/admin";
        }

        productService.addNewProduct(product, departmentID);
        return "redirect:/admin";
    }
    /**
     * Update product category
     * 
     * @POST
     * @param department
     * @return
     */
    @PostMapping(path = "/admin/update-product", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String updateProduct(
            @RequestParam Long id,
            @RequestParam Long departmentID) {
        productService.updateProductDepartment(id, departmentID);
        return "redirect:/admin";
    }

}
