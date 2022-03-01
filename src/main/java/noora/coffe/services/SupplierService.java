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
    

    
    /**
     * 
     * @param supplier
     * @return
     */
    public boolean addNewSupplier(Supplier supplier) {
        // TODO VALIDATE 
        // if ( supplier.getName().equals("") ) { return false; }
        // if ( supplier.getContact().equals("") ) { return false; }
        // if ( supplier.validEmail(supplier.getEmail()) ) { return false; }
        supplier.getName().trim();
        supplierRepo.save( supplier );
        return true;
    }
    /**
     * 
     * @param id
     * @return
     */
    @Transactional
    public List<Supplier> getSupplierList( Long id )  {
        return ( id == -1L ) ? supplierRepo.findAll() : supplierRepo.findAllById( id );
    }
    /**
     * 
     * @param name
     * @return
     */
    @Transactional
    public boolean addNewDepartment( String name ) {   

        System.out.println("========================");
        System.out.println("=========NOT READY EAT========");
        System.out.println("========================");

        return false;
        // // Not Empty
        // if ( name.equals("") ) { return false; }
        
        // // Check Exist same name in a DB
        // if( supplierRepo.findByName(name) != null ){ return false; }
        
        // // Save to DB
        // supplierRepo.save( new Supplier( name.trim(), name, name, null ) );
        // return true;
    }
    /**
     * Remove cascade 
     * @param department
     */
    @Transactional
    public boolean deleteById( Long id ) {
        if( supplierRepo.findById(id) != null ){ return false; }
        supplierRepo.deleteById( id );
        return true;
    }
    

}
