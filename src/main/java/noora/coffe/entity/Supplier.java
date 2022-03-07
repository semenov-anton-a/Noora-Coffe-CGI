package noora.coffe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier extends AbstractPersistable<Long> {

    /**
     * Сущность поставщика
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String contact;
    private String email;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;
    
    /**
     * 
     * @param name
     * @param contact
     * @param email
     * @param products
     */
    public Supplier(String name, String contact, String email, List<Product> products) {
        this.name = name;
        this.contact = contact;
        this.email = email;
    }
    /**
     * 
     * @param email
     * @return
     */
    public boolean validEmail( String email ) {
        // TODO: Wrte validation of email
        return true;
    }

   
}
