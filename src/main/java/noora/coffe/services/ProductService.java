package noora.coffe.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noora.coffe.entity.*;
import noora.coffe.repos.*;

@Service
public class ProductService {

    @Autowired
    DepartmentRepo departmentRepo;
    
    @Autowired
    SupplierRepo supplierRepo;

    @Autowired
    ProductRepo productRepo;

    /**
     * Sort Products And add Department name
     * 
     * @param departmentList
     * @return
     */
    // public List<Product> sortProductsAndDepartmentName(List<Department> departmentList) {
    //     Integer size = departmentList.size();
    //     List<Product> products = new ArrayList<>();

    //     for (int i = 0; i <= size - 1; i++) {
    //         if (!departmentList.get(i).getProducts().isEmpty()) {
    //             List<Product> p = departmentList.get(i).getProducts();

    //             String department = departmentList.get(i).getName();

    //             p.forEach(product -> {
    //                 product.setTransientCategory(department);
    //             });

    //             products.addAll(p);
    //         }
    //     }

    //     Collections.sort(products,
    //             (Product o1, Product o2) -> o1.getId().compareTo(o2.getId()));

    //     return products;
    // }

    /**
     * Add new Product
     * 
     * @param product
     * @param departmentID
     */
    @Transactional
    public void addNewProduct(
        Product product, 
        Long departmentID
        // ,Long supplierID
        // ,Long makerID
    ){
        
        System.out.println("==========================");
        Department dep = departmentRepo.getById( departmentID );
        Product p = product.setDepartment( dep );
        productRepo.save( p );        
        System.out.println("==========================");

        // departmentRepo.save( product );
        // departmentRepo.save(
        //         departmentRepo.getById(departmentID).addProduct(product));
    }
    /**
     * Update product Department ID
     * 
     * @param id
     * @param departmentID
     */
    @Transactional
    public void updateProductDepartment(Long id, Long departmentID) {
        departmentRepo.save(
                departmentRepo.getById(departmentID)
                        .updateProduct(productRepo.getById(id)));
    }
    /**
     * Delete Product
     * @param id
     */
    public void deleteById(Long id) { productRepo.deleteById(id); }


    public void addEntityDependencies( List data ){

        System.out.println( data.get(1) );

    }


    /**
     * GET ALL Products
     * @return
     */
    public List<Product> getProducts() { return productRepo.findAll(); }
    public void save( Product product ) {

        // if( product.getDepartment() == null ){
        //     product.setDepartment( departmentRepo.getById(1L) );
        // }
        
        // productRepo.save( product );

        // if( product.getSupplier() == null ){
        //     product.setSupplier( supplierRepo.getById(1L) );
        // }

        productRepo.save( product );
        


    }


    /**
     * Find All Products where Department is NULL
     * @param pageable
     * @return Page<Product>
     */
    public Page<Product> getProduct_without_department( Pageable pageable ) {
        return productRepo.findAllProductByDepartmentId( null, pageable );
    }
    public Page<Product> getProduct_without_supplier( Pageable pageable ) {
        return productRepo.findAllProductBySupplierId( null, pageable );
    }
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll( pageable );
    }


    // public List<Product> addEntityDependencies(
    //     List<Department> departmentList,
    //     List<Supplier> supplierList
    // ){
    //     Integer size = departmentList.size();
    //     List<Product> products = new ArrayList<>();

    //     for (int i = 0; i <= size - 1; i++) {
    //         if (!departmentList.get(i).getProducts().isEmpty()) {
    //             List<Product> p = departmentList.get(i).getProducts();

    //             String department = departmentList.get(i).getName();
    //             String department = departmentList.get(i).getName();

    //             p.forEach(product -> {
    //                 product.setTransientCategory(department);
    //             });

    //             products.addAll(p);
    //         }
    //     }

    //     Collections.sort(products,
    //             (Product o1, Product o2) -> o1.getId().compareTo(o2.getId()));

    //     return products;
    // }




    // public void 



}
