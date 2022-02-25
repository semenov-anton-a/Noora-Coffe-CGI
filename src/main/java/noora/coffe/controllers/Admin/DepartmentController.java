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
public class DepartmentController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProductService productService;

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
}
