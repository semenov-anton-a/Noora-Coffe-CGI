package noora.coffe.controllers.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

@Controller
public class DepartmentController extends CommonController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProductService productService;

    /**
     * 
     * @param model
     * @return
     */
    @ModelAttribute("departmentsList")
    private List<Department> getDepartmentsList( Model model , @RequestParam(defaultValue = "-1") Long Id) {
        List<Department> departments = departmentService.getDepartments( Id );
        model.addAttribute("department", departments);
        model.addAttribute("styleActiveClass", Id );
        return departments;
    }

    @GetMapping("/admin/department")
    public String getDepartments(Model model, @RequestParam(defaultValue = "0") Integer page) {
        


        System.out.println("=================____DEPARTMENTS____=====================");
        // System.out.println(departments);
        System.out.println("================================================");

        System.out.println("=================____PRODUCTDS____=====================");
        // System.out.println(products);
        System.out.println("================================================");


        return "admin/departments";
    }

    /**
     * 
     * @param model
     * @return
     */
    // @GetMapping("/admin/department")
    // public String getDepartments( Model model, @RequestParam(defaultValue = "0")
    // Integer page ){

    // Pageable pageable = PageRequest.of( page, 1 );

    // Page<Department> pageTable = departmentRepo.findAll( pageable );

    // System.out.println( pageTable );

    // model.addAttribute( "styleActiveClass", -1 );
    // model.addAttribute( "department", pageTable);

    // int pageB = 0;
    // pageB = ( pageTable.hasPrevious() ) ? page - 1 : -1 ;

    // int pageN = 0;
    // pageN = ( pageTable.hasNext() ) ? page + 1: -1;

    // model.addAttribute( "pageBack", pageB );
    // model.addAttribute( "pageNext", pageN );

    // this.showPaginations(model, true, "/admin/department");

    // return "admin/departments";
    // }

    private DepartmentController showPaginations(Model model, boolean pagination, String url) {
        model.addAttribute("pagination", pagination);
        model.addAttribute("paginationUri", url);
        return this;
    }

    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/admin/department/{id}")
    public String getDepartmentsById(Model model, @PathVariable Long id) {
        this.getDepartmentsList( model, id );
        
        // List<Product> products = productService.getProducts();

        // System.out.println( products );
        // List<Department> departmentsForProducts = departmentService.getDepartmentsById(id);
        // model.addAttribute("department", departmentsForProducts);
        // model.addAttribute("styleActiveClass", id);
        return "admin/departments";
    }
    /**
     * 
     * @param model
     * @return
     */
    // @GetMapping("/admin/departments/page={id}")
    // public String getProductsByDepartment( Model model ){

    // // model.addAttribute( "department", departmentService.getDepartments() );
    // // model.addAttribute( "allProducts", productService.getProducts() );

    // return "admin/departments";
    // }
    /**
     * @POST (/admin/department)
     * @param department
     * @return
     */
    @PostMapping(path = "/admin/department", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String addNewDepartment(Department department, String option) {

        switch (option) {
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
