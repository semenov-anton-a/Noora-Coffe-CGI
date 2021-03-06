package noora.coffe.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noora.coffe.repos.DepartmentRepo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.transaction.annotation.Transactional;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department extends AbstractPersistable<Long> {

    /**
     * Сущность отдела
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique=true)
    private String name;

    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "department_id")
    // private List<Product> products;
    
    @OneToMany(mappedBy="department",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;

    public Department( String name ) {
        this.name = name;
    }

    public Department addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    @Transactional
    public Department updateProduct( Product product ) {
        this.products.remove(product);        
        this.products.add(product);        
        return this;    
    }
}
