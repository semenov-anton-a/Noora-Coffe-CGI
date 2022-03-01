package noora.coffe.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

@RestController
public class TestContoller{
    
    @Autowired
    ProductRepo productRepo;
    
    @Autowired
    DepartmentRepo departmentRepo;
    
    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    ProductService productService;

    @GetMapping("/admin/test_console")
    public void testConsole(){
        System.out.println("========TEST Controller BEGIN===============");



    // Product p = new Product( "0_TEST_2", departmentRepo.getById( 1L )  );


        // productRepo.save( p );

        // System.out.println( p );



        System.out.println("========TEST Controller ENDs===============");
    }







}
