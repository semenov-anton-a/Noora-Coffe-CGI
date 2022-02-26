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
public class DepartmentController extends CommonController{

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProductService productService;


    @GetMapping("/admin/departments")
    public String getDepartments( Model model ){
        model.addAttribute( "department", departmentService.getDepartments() );
        model.addAttribute( "allProducts", productService.getProducts() );
        return "admin/departments";
    }
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/admin/departments/page={id}")
    public String getProductsByDepartment( Model model ){
        
        
        // model.addAttribute( "department", departmentService.getDepartments() );
        // model.addAttribute( "allProducts", productService.getProducts() );
        
        return "admin/departments";
    }
    /**
     * @POST (/admin/department)
     * @param department
     * @return
     */
    @PostMapping(path = "/admin/department", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String addNewDepartment( Department department, String option ) {
        
        switch (option) 
        {
            case "add":
                departmentService.addNewDepartment(department);
                break;                
            case "delete":
                departmentService.deleteById(department);
                break;
        }

        return "redirect:/admin";
    }

}
