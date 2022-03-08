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
public class MakerService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    SupplierRepo supplierRepo;
    
    @Autowired
    MakerRepo makerRepo;
    
    /**
     * 
     * @param supplier
     * @return
     */
    public boolean add(Maker maker) {
        // TODO VALIDATE 
        if ( maker.getName().equals("") ) { return false; }
        if ( maker.getUrl().equals("") ) { return false; }
        
        maker.getName().trim();
        
        makerRepo.save( maker );
        return true;
    }
    /**
     * 
     * @param id
     * @return
     */
    @Transactional
    public List<Maker> getList( Long id )  {
        return ( id == -1L ) ? makerRepo.findAll() : makerRepo.findAllById( id );
    }
    public List<Maker> getList()  {return this.getList(-1L);}
 
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
    public void update(Maker maker) {
        makerRepo.save( maker );
    }
    

}
