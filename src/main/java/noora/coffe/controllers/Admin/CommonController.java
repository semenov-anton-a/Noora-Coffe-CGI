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

    

    



}
