package noora.coffe.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product extends AbstractPersistable<Long> {

    /**
     * Сущность товаров
     */

    String name;
    // String description;
    // String image;
    // BigDecimal price;
}
