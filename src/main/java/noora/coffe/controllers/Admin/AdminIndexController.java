package noora.coffe.controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.entity.*;
import noora.coffe.repos.*;

@Controller
public class AdminIndexController {
    
    // @Autowired
    // DepartmentRepo departmentRepo;


    @GetMapping("/admin")
    public String getAdminIndex( Model model ) {
        
        // Department res = departmentRepo.findByName( "Kahvilaitteet" );

        // System.out.println( res.getName() );

        model.addAttribute("department", departmentRepo.findAll() );
        
        return "admin/index";
    }


    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired 
    ProductRepo productRepo;

    @PostMapping("/admin/department")
    public String addNewDepartment( @RequestParam String department ) {

        if( department.length() == 0  ){
            return "redirect:/admin";
        }

        Department dep = new Department( department.trim(), null );
        departmentRepo.save( dep ); 



        // System.out.println(dep);

        // Department result = departmentRepo.findByName( department ); 
        // if( result == null ){}

        // System.out.println( result );
        // itemRepository.save( new Item(name) );
        // return "redirect:admin/index";
        return "redirect:/admin";
    }

}   
