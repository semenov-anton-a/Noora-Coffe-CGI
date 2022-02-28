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
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<Department> departments = departmentService.getDepartments(Id);
        model.addAttribute("department", departments);
        model.addAttribute("styleActiveClass", Id);
        return departments;
    }


    private int itemsCoutOfPage = 4;
    private DepartmentController productPageable(Model model,  Page<Product> productList, Integer pageNum  ){
        int pageB = 0;
        pageB = ( productList.hasPrevious() ) ? pageNum - 1 : -1;

        int pageN = 0;
        pageN = (productList.hasNext() ) ? pageNum + 1 : -1;

        model.addAttribute("pageBack", pageB);
        model.addAttribute("pageNext", pageN);

        return  this.showPaginations( model, true, "/admin/department" );
    }
    private DepartmentController showPaginations(Model model, boolean pagination, String url) {
        model.addAttribute("pagination", pagination);
        model.addAttribute("paginationUri", url);
        return this;
    }
    /**
     * Show All Products
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/department")
    public String getDepartments(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productRepo.findAll( pageable );
        this.productPageable( model, productList, page );
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
        this.productPageable( model, productList, page );
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
        departmentService.addNewDepartment(name);
        return "redirect:/admin/department";
    }
    /**
     * 
     */

}// END
