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
public class AdminIndexController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProductService productService;

    /**
     * @GET (/admin)
     * @param model
     * @return
     */
    @GetMapping("/admin")
    public String getAdminIndex(Model model) {
        List<Department> departmentList = departmentService.getAllDependencies();
        
        model.addAttribute("department", departmentList);
        model.addAttribute("productList",
                productService.sortProductsAndDepartmentName(departmentList));

        return "admin/index";
    }

    /**
     * Add new department
     * 
     * @POST (/admin/add-department)
     * @param department
     * @return
     */
    @PostMapping( 
        path = "/admin/add-department",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } 
    )
    public String addNewDepartment( Department department ) {
        if ( department.getName().equals("") ) {
            return "redirect:/admin";
        }
        departmentService.addNewDepartment(department);
        return "redirect:/admin";
    }
    /**
     * Add new department
     * 
     * @POST (/admin/add-department)
     * @param department
     * @return
     */
    @PostMapping( 
        path = "/admin/remove-department",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } 
    )
    public String removeDepartment( Department department ) {        
        departmentService.deleteById(department);
        return "redirect:/admin";
    }

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



    @PostMapping(path = "/admin/add-supplier", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String addNewSupplier(
            Supplier supplier 
    ){

        return "redirect:/admin";
    }
}
