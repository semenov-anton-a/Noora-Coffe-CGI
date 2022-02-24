package noora.coffe.repos;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import noora.coffe.entity.Product;


public interface ProductRepo extends CrudRepository<Product, Long> {}
