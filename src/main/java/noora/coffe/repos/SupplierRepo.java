package noora.coffe.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import noora.coffe.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {}
