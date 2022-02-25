package noora.coffe.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addNewDepartment(String department) {
        departmentRepo.save(new Department(department.trim()));
    }

}
