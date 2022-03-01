package noora.coffe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noora.coffe.entity.*;
import noora.coffe.repos.*;


@Service
public class DepartmentService {


    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    
    /**
     * 
     * @param id
     * @return
     */
    @Transactional
    public List<Department> getDepartments( Long id )  {
        return ( id == -1L ) ? departmentRepo.findAll() : departmentRepo.findAllById( id );
    }

    /**
     * 
     * @param name
     * @return
     */
    @Transactional
    public boolean addNewDepartment( String name ) {   
        // Not Empty
        if ( name.equals("") ) { return false; }
        
        // Check Exist same name in a DB
        if( departmentRepo.findByName(name) != null ){ return false; }
        
        // Save to DB
        departmentRepo.save( new Department( name.trim() ) );
        return true;
    }
    /**
     * Remove cascade 
     * @param department
     */
    @Transactional
    public boolean deleteById( Long id ) {
        if( departmentRepo.findById(id) != null ){ return false; }
        departmentRepo.deleteById( id );
        return true;
    }

    public Department getById(Long id) {
        return departmentRepo.getById(id);
    }
    
}
