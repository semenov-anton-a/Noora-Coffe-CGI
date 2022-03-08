package noora.coffe.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    Supplier findByName( String name );
    Boolean existsByName( String name );
    List<Supplier> findAllById(Long id);

}
