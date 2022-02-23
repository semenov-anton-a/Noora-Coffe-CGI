package noora.coffe.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.jpa.domain.AbstractPersistable;

// @Data
@Entity
@NoArgsConstructor
// @AllArgsConstructor
public class Product extends AbstractPersistable<Long>{
    
    /**
     *  Сущность товаров
     */
    @OneToMany(mappedBy="product")
    private List<Department> departmentList; 

    String      name;
    String      description;
    String      image;
    BigDecimal  price;
}
