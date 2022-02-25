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
public class SupplierService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    SupplierRepo supplierRepo;
    

    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }



    public boolean addNewSupplier(Supplier supplier) {
        if ( supplier.getName().equals("") ) {
            return false;
        }
        supplier.getName().trim();
        supplierRepo.save( supplier );
        return true;
    }

    // @Transactional
    // public boolean addNewDepartment( Department department ) {
        
    //     if ( department.getName().equals("") ) {
    //         return false;
    //     }
        
    //     departmentRepo.save(
    //         new Department( department.getName().trim() )
    //     );

    //     return true;
    // }

    // /**
    //  * Remove cascade 
    //  * @param department
    //  */
    // @Transactional
    // public void deleteById(Department department) {
    //     departmentRepo.deleteById( department.getId() );
    // } 

}
