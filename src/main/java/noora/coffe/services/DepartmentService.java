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
    public List<Department> getDepartments( Long id ) 
    {
        if( id == -1L )
        { 
            return departmentRepo.findAll(); 
        }
        
        return departmentRepo.findAllById( id );
    }

    @Transactional
    public boolean addNewDepartment( Department department ) 
    {
        if ( department.getName().equals("") ) {
            return false;
        }
        
        departmentRepo.save(
            new Department( department.getName().trim() )
        );

        return true;
    }
    /**
     * Remove cascade 
     * @param department
     */
    @Transactional
    public void deleteById(Department department)
    {
        departmentRepo.deleteById( department.getId() );
    }
}
