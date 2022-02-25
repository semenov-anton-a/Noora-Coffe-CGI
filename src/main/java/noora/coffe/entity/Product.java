package noora.coffe.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product extends AbstractPersistable<Long> {

    /**
     * Сущность товаров
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    // String description;
    // String image;
    // BigDecimal price;



    @Transient
    private transient String category_tras;
    
    @Transient
    private transient String maker_tras;
    
    @Transient
    private transient String supplier_tras;


    public Product setTransientCategory(String str) {
        this.category_tras = str;
        return this;
    }
    public Product setTransientMaker(String str) {
        this.maker_tras = str;
        return this;
    }
    public Product setTransientSupplier(String str) {
        this.supplier_tras = str;
        return this;
    }


    


}
