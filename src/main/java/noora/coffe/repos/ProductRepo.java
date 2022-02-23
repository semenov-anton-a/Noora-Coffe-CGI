package noora.coffe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import noora.coffe.entity.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {}
