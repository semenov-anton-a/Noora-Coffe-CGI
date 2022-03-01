package noora.coffe.controllers.Admin;

import java.util.List;
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
    private List<Department> getDepartmentsList(Model model, @RequestParam(defaultValue = "-1") Long Id) {
        List<Department> departments = departmentService.getList(Id);
        model.addAttribute("department", departments);
        model.addAttribute("styleActiveClass", Id);
        return departments;
    }


    
    /**
     * Show All Products
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/department")
    public String getDepartments(Model model, @RequestParam(defaultValue = "0") Integer page) {
        this.getDepartmentsList(model, 0L);
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getProduct_without_department( pageable );
        
        super.productPageable(model, productList, page, "department");
        model.addAttribute("productList", productList);
        return "admin/departments";
    }
    /**
     * Show All Products
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/department/all")
    public String getDepartmentsAll(Model model, @RequestParam(defaultValue = "0") Integer page) {
        this.getDepartmentsList(model, -1L);
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getAll( pageable );
        
        super.productPageable(model, productList, page, "department/all");
        model.addAttribute("productList", productList);
        return "admin/departments";
    }
    /**
     * Show Products by Category
     * @param model
     * @return
     */
    @GetMapping("/admin/department/{id}")
    public String getDepartmentsById(Model model, @PathVariable Long id, @RequestParam(defaultValue = "0") Integer page) {
        this.getDepartmentsList(model, id);

        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productRepo.findAllProductByDepartmentId( id, pageable );
        
        super.productPageable(model, productList, page, "department");
        
        model.addAttribute("productList", productList);
        return "admin/departments";
    }
    /**
     * @POST (/admin/department)
     * @param department
     * @return
     */
    @PostMapping(
        path = "/admin/department/add", 
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } )
    public String addNewDepartment( String name) {
        departmentService.add(name);
        return "redirect:/admin/department";
    }
    /**
     * 
     */

}// END
