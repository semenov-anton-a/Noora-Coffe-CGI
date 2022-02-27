package noora.coffe.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByName( String name );
    Boolean existsByName( String name );
    List<Department> findAllById(Long id);

}
