package noora.coffe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import noora.coffe.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
