package noora.coffe.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.Department;
import noora.coffe.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // List<Product> findAllProductByCategoryId( Long id );


    // List<Product> findAllProductByDepartmentId( @Param("id") Long id,  Pageable pageable );
    
    Page<Product> findAllProductByDepartmentId( Long id, Pageable pageable );
    Page<Product> findAllProductBySupplierId( Long id, Pageable pageable );
    Page<Product> findAllProductByMakerId( Long id, Pageable pageable );

    // List<Product> findAllProductByDepartmentId( @Param("id") Long id );
    // List<T> findAllProductByDepartmentId( @Param("id") Long id );
    // List<Product> findAllProductByDepartmentId( @Param("id") Long id);


}
