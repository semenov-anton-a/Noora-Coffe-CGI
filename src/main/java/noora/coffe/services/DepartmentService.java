package noora.coffe.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noora.coffe.controllers.Admin.DepartmentController;
import noora.coffe.entity.*;
import noora.coffe.repos.*;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ProductRepo productRepo;

    public List<Department> getAllDependencies() {
        return departmentRepo.findAll();
    }

    public void addNewDepartment( Department department ) {
        departmentRepo.save(
            new Department( department.getName().trim() )
        );
    }

    public void deleteById(Department department) {
        departmentRepo.deleteById( department.getId() );
    }

}
