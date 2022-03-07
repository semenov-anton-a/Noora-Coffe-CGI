package noora.coffe.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Component;

@Data 
@NoArgsConstructor
@Component
@Scope( value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class ShoppingCart extends AbstractPersistable<Long>{


    private float totalPrice;
    private int iterator = 0;
    private Map<Product, Long> items = new HashMap<>();

    public void addToCart(Product item)
    {
        if(items.containsKey(item)){
            Long count = items.get(item);
            items.put(item, count + 1);
        } else {
            items.put(item, 1L);
        }

        this.totalPrice = this.totalPrice + Float.parseFloat( item.getPrice() );
        this.iterator++;
    }

    public Map getItems() { return this.items; }
    public int getIterator(){ return this.iterator; }

    //
    public Float getTotalPrice(){ return this.totalPrice; }
    
}
