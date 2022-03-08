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
public class AdminMakerController extends CommonControllerAdvice {

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

    @Autowired
    MakerRepo makerRepo;

    @Autowired
    MakerService makerService;

    /**
     * 
     * @param model
     * @return
     */
    @ModelAttribute("makerList")
    private List<Maker> getMakerList(Model model, @RequestParam(defaultValue = "-1") Long Id) {
        new AdminCommon().setModelAttributes( model );
        List<Maker> sup = makerService.getList(Id);
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
    @GetMapping("/admin/makers")
    public String getMakers(Model model, @RequestParam(defaultValue = "0") Integer page) {
        new AdminCommon().setModelAttributes( model );
        this.getMakerList( model, 0L);
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getProduct_without_maker( pageable );
        
        super.productPageable(model, productList, page, "makers");
        model.addAttribute("productList", productList);
        return "admin/makers";
    }
    /**
     * Show All Products
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/admin/makers/all")
    public String getSupplierAll(Model model, @RequestParam(defaultValue = "0") Integer page) {
        new AdminCommon().setModelAttributes( model );
        
        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productService.getAll( pageable );
        
        super.productPageable(model, productList, page, "makers/all");
        model.addAttribute("productList", productList);
        return "admin/makers";
    }
    /**
     * Show Products by Category
     * @param model
     * @return
     */
    @GetMapping("/admin/makers/{id}")
    public String getMakersById( Model model, @PathVariable Long id, @RequestParam(defaultValue = "0") Integer page ) {
        new AdminCommon().setModelAttributes( model );
        this.getMakerList(model, id);

        Pageable pageable = PageRequest.of( page, this.itemsCoutOfPage );
        Page<Product> productList = productRepo.findAllProductBySupplierId( id, pageable );
        super.productPageable( model, productList, page,  "makers");
        model.addAttribute("productList", productList);
        return "admin/makers";
    }

    /**
     * @POST (/admin/suppliers)
     * @param department
     * @return
     */
    @PostMapping( path = "/admin/makers",
    consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addNewMaker(
            @RequestParam String name, 
            @RequestParam String url,  
            String option 
    ){

        makerService.add( new Maker( null, name, url ) );
        return "redirect:/admin/makers";
    }

    /**
     * @POST (/admin/suppliers)
     * @param department
     * @return
     */
    @PostMapping( path = "/admin/makers/update/{id}",
    consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String uodateMaker(Maker maker){
        makerService.update( maker );
        return "redirect:/admin/makers";
    }
    // /**
    //  * 
    //  */

}// END
