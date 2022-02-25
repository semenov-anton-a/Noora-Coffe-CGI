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

@Controller
public class AdminIndexController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/admin")
    public String getAdminIndex(Model model) {

        List<Department> dep =  departmentRepo.findAll();
        model.addAttribute( "department", dep  );
        
        List<Product> products = new Department().listProducts(dep);
        model.addAttribute( "productList", products  );
        
        return "admin/index";
    }


    /**
     *  Add new department 
     *  @POST
     *  @param department
     *  @return
     */
    @PostMapping("/admin/add-department")
    public String addNewDepartment(@RequestParam String department) {

        if (department.length() == 0) {
            return "redirect:/admin";
        }

        Department dep = new Department( department.trim() );
        departmentRepo.save(dep);

        return "redirect:/admin";
    }


    /**
     *  Add new product 
     *  @POST
     *  @param department
     *  @return
     */
    @PostMapping(  path = "/admin/add-product",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } )
    public String addNewProduct( Product product, @RequestParam Long departmentID ) {

        if( product.getName().equals("") ){
            return "redirect:/admin";
        }  
        
        Department dep = departmentRepo.getById( departmentID );
        departmentRepo.save( dep.addProduct( product ) );
        
        return "redirect:/admin";
    }



    /**
     *  Update product category 
     *  @POST
     *  @param department
     *  @return
     */
    @PostMapping(  path = "/admin/set-category",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } )
    public String updateProduct( @RequestParam Long id, @RequestParam Long departmentID ) {

        Product product = productRepo.getById( id );
        Department dep = departmentRepo.getById( departmentID );
        
        

        departmentRepo.save( dep.updateProduct( product ) );

        // System.out.println( product );
        // System.out.println( dep );


        return "redirect:/admin";
    }

}
