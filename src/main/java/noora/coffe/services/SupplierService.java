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
    public boolean add(Supplier supplier) {
        // TODO VALIDATE 
        if ( supplier.getName().equals("") ) { return false; }
        if ( supplier.getContact().equals("") ) { return false; }
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
    public List<Supplier> getList( Long id )  {
        return ( id == -1L ) ? supplierRepo.findAll() : supplierRepo.findAllById( id );
    }
    public List<Supplier> getList()  {return this.getList(-1L);}
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
    public void update(Supplier s) {
        supplierRepo.save( s );
    }
    

}
