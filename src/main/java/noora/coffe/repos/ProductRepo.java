package noora.coffe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.Department;
import noora.coffe.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {}
