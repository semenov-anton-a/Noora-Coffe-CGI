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
public class SupplierController{
    

    @PostMapping(
        path = "/admin/add-supplier", 
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String addNewSupplier( Supplier supplier ){

        System.out.println( supplier );

        return "redirect:/admin";
    }


}
