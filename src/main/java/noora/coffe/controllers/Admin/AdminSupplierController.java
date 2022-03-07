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

import noora.coffe.controllers.CommonControllerAdvice;
import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

@Controller
public class AdminSupplierController extends CommonControllerAdvice {

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
        List<Supplier> sup = supplierService.getList(Id);
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
        this.getSupplierList(model, 0L);
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getProduct_without_supplier( pageable );
        
        super.productPageable(model, productList, page, "suppliers");
        model.addAttribute("productList", productList);
        return "admin/suppliers";
    }
    /**
     * Show All Products
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/suppliers/all")
    public String getSupplierAll(Model model, @RequestParam(defaultValue = "0") Integer page) {
        
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getAll( pageable );
        
        super.productPageable(model, productList, page, "suppliers/all");
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

        supplierService.add( new Supplier( name, contact, email, null ) );
        return "redirect:/admin/suppliers";
    }


    /**
     * @POST (/admin/suppliers)
     * @param department
     * @return
     */
    @PostMapping( path = "/admin/suppliers/update/{id}",
    consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String uodateSuppliers(Supplier s){
        supplierService.update( s );
        return "redirect:/admin/suppliers";
    }
    // /**
    //  * 
    //  */

}// END
