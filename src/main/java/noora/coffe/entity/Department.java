package noora.coffe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

import org.hibernate.annotations.NotFound;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department extends AbstractPersistable<Long> {

    /**
     * Сущность отдела
     */

    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn( name = "PRODUCT" )
    private Product product;
    // private List<Product> product;

    public Department( String name, Product product )
    {
        this.name = name;
        this.product = product;

    }

}
