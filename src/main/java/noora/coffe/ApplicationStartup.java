package noora.coffe;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**  */
import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;
/**  */


@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    // DepartmentService
    @Autowired DepartmentService departmentService;
    @Autowired DepartmentRepo departmentRepo;

    // ProductService
    @Autowired ProductService productService;
    @Autowired ProductRepo productRepo;

    /** -------------------------- */

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        this.makeFakeDepartments().makeFakeProduct();
    }

    @Transactional
    private ApplicationStartup makeFakeDepartments() 
    {    
        String noCategory = "No Category";
        String kahvilaitteet = "Kahvilaitteet";
        String kulutustuoteet = "Kulutustuoteet";
        
        if( ! departmentRepo.existsByName(noCategory) ){
            System.out.println("INSERT " + noCategory);
            departmentRepo.save( new Department(noCategory) );
        }

        if( ! departmentRepo.existsByName(kahvilaitteet) ){
            System.out.println("INSERT " + kahvilaitteet);
            departmentRepo.save( new Department( kahvilaitteet ) );
        }

        if( ! departmentRepo.existsByName(kulutustuoteet) ){
            System.out.println("INSERT " + kulutustuoteet);
            departmentRepo.save( new Department(kulutustuoteet) );
        }

        return this;
    }


    @Transactional
    private ApplicationStartup makeFakeProduct(){

        if( productRepo.findAll().size() != 0 ){ return this; }
        
        System.out.println( "==================" );
        System.out.println(" INSERT PRODUCS ................");

        Product p_0 = new Product( null, "0_product_0", null  );        
        Product p_1 = new Product( null, "1_product_1", null  );
        Product p_2 = new Product( null, "2_product_2", null  );
        Product p_3 = new Product( null, "3_product_3", null  );
        
        Product p_4 = new Product( null, "4_product_4", null  );
        Product p_5 = new Product( null, "5_product_5", null  );
        Product p_6 = new Product( null, "6_product_6", null  );
        
        Product p_7 = new Product( null, "7_product_7", null  );
        Product p_8 = new Product( null, "8_product_8", null  );
        Product p_9 = new Product( null, "9_product_9", null  );
        
        productService.addNewProduct( p_0 , 1L );

        productService.addNewProduct( p_1 , 1L );
        productService.addNewProduct( p_2 , 2L );
        productService.addNewProduct( p_3 , 3L );
        
        productService.addNewProduct( p_4 , 1L );
        productService.addNewProduct( p_5 , 2L );
        productService.addNewProduct( p_6 , 3L );
        
        productService.addNewProduct( p_7 , 1L );
        productService.addNewProduct( p_8 , 2L );
        productService.addNewProduct( p_9 , 3L );
        
        return this;
    }


}