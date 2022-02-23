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
public class Maker extends AbstractPersistable<Long>{

    /**
     *  Сущность производителя
     */

    
    String name; 
    String url;

}
