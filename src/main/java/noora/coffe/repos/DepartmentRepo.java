package noora.coffe.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.Department;
import noora.coffe.entity.Product;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByName( String name );
    Boolean existsByName( String name );
    List<Department> findAllById(Long id);


    // List<Department> findAllProductsOrderById( Long id );
    // List<Product> findAllProducts();

}
