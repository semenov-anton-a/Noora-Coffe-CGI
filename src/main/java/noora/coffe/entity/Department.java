package noora.coffe.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.jpa.domain.AbstractPersistable;

// @Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department extends AbstractPersistable<Long> {

    /**
     *  Сущность отдела
     */
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;



    String name;
    

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

}
