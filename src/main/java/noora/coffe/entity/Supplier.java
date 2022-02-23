package noora.coffe.entity;


import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Supplier extends AbstractPersistable<Long>{
    
    /**
     *  Сущность поставщика
     */
     String company;
     String contact;
     String email;

}
