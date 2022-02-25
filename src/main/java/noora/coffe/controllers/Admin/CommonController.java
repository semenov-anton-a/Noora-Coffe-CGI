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
public class CommonController {

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

    /**
     * @GET (/admin)
     * @param model
     * @return
     */
    @GetMapping("/admin")
    public String getAdminIndex(Model model) {
        
        List<Department> departmentList = departmentService.getAllDepartments();
        List<Supplier> supplierList = supplierService.getAllSuppliers();
        

        productService.addEntityDependencies( departmentList );
        
        model.addAttribute("department", departmentList);

        // List<Maker> makerList = makerService.getAllMakers();
        // model.addAttribute("productList",
        //         // productService.sortProductsAndDepartmentName(departmentList) 
        //         // productService.addEntityDependencies(
        //         //     departmentList, supplierList
        //         // ) 
        // );

        // System.out.println( supplierService.getAllSuppliers().get(0).getId() );
        
        // model.addAttribute("supplier", supplierService.getAllSuppliers() );

        // return "admin/index";
        return "admin/test";
    }
}
