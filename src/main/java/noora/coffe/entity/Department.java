package noora.coffe.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
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

    private static final List List = null;

    /**
     * Сущность отдела
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private List<Product> products;

    public Department(String name) {
        this.name = name;
    }

    public Department addProduct( Product product ) {
        this.products.add( product );        
        return this;    
    }

    @Transactional
    public Department updateProduct( Product product ) {
        this.products.remove(product);        
        this.products.add(product);        
        return this;    
    }
    
    public List<Product> listProducts( List<Department> departmentProducts ) {
        
        Integer size = departmentProducts.size();
        List<Product> products = new ArrayList<>();
        
        for( int i = 0; i <= size-1; i++ ){
            if( ! departmentProducts.get(i).getProducts().isEmpty() ){
                List<Product> p = departmentProducts.get(i).getProducts();

                String department = departmentProducts.get(i).getName();

                p.forEach( product -> { 
                    product.setTransientCategory( department ); 
                });

                products.addAll( p );
            }
        }
        
        Collections.sort( products, 
            (Product o1, Product o2) -> o1.getId().compareTo(o2.getId()) 
        );

        return products;
    }


}
