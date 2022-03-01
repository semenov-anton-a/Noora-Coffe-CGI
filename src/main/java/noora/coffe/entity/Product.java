package noora.coffe.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noora.coffe.repos.DepartmentRepo;
import noora.coffe.repos.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

@Entity
@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
public class Product extends AbstractPersistable<Long> {
    
    /**
     * Сущность товаров
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    String name;
    // String description;
    // String image;
    // BigDecimal price;
    
    
    
    
    @ManyToOne
    private Department department;
    public Product setDepartment(Department dep) {
        this.department = dep;
        return this;
    }


    @ManyToOne
    private Supplier supplier;
    public Product setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }


    public Product( String name, Department dep ){
        this.name = name;
        this.setDepartment(dep);
    };
    
   

}
