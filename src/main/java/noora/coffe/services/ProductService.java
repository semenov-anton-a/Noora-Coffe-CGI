package noora.coffe.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noora.coffe.entity.*;
import noora.coffe.repos.*;

@Service
public class ProductService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    /**
     * Sort Products And add Department name
     * 
     * @param departmentList
     * @return
     */
    public List<Product> sortProductsAndDepartmentName(List<Department> departmentList) {
        Integer size = departmentList.size();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i <= size - 1; i++) {
            if (!departmentList.get(i).getProducts().isEmpty()) {
                List<Product> p = departmentList.get(i).getProducts();

                String department = departmentList.get(i).getName();

                p.forEach(product -> {
                    product.setTransientCategory(department);
                });

                products.addAll(p);
            }
        }

        Collections.sort(products,
                (Product o1, Product o2) -> o1.getId().compareTo(o2.getId()));

        return products;
    }

    /**
     * Add new Product
     * 
     * @param product
     * @param departmentID
     */
    @Transactional
    public void addNewProduct(Product product, Long departmentID) {
        departmentRepo.save(
                departmentRepo.getById(departmentID).addProduct(product));
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
