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
public class SupplierController extends CommonController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    SupplierService supplierService;

    @Autowired
    ProductService productService;

    /**
     * 
     * @param model
     * @return
     */
    @ModelAttribute("suplierList")
    private List<Supplier> getSupplierList(Model model, @RequestParam(defaultValue = "-1") Long Id) {
        List<Supplier> sup = supplierService.getSupplierList(Id);
        model.addAttribute("sup", sup);
        model.addAttribute("styleActiveClass", Id);
        return sup;
    }

    /**
     * Show All Products
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/suppliers")
    public String getSuppliers(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productRepo.findAll( pageable );
        super.productPageable(model, productList, page, "suppliers");
        
        model.addAttribute("productList", productList);
        return "admin/suppliers";
    }
    /**
     * Show Products by Category
     * @param model
     * @return
     */
    @GetMapping("/admin/suppliers/{id}")
    public String getDepartmentsById( Model model, @PathVariable Long id, @RequestParam(defaultValue = "0") Integer page ) {
        this.getSupplierList(model, id);

        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productRepo.findAllProductBySupplierId( id, pageable );
        super.productPageable( model, productList, page,  "suppliers");
        model.addAttribute("productList", productList);
        return "admin/suppliers";
    }
    /**
     * @POST (/admin/suppliers)
     * @param department
     * @return
     */
    @PostMapping( path = "/admin/suppliers",
    consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addNewSupplier(
            @RequestParam String name, 
            @RequestParam String contact,  
            @RequestParam String email,  
            String option 
    ){

        supplierService.addNewSupplier( new Supplier( name, contact, email, null ) );
        return "redirect:/admin/suppliers";
    }
    // /**
    //  * 
    //  */

}// END
