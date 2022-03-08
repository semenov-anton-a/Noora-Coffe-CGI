package noora.coffe.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noora.coffe.repos.DepartmentRepo;
import noora.coffe.repos.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

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
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    String  name;
    String  description;
    int     priceBig;
    int     priceSmall;
    Boolean active = false;
    
    
    // BigDecimal priceDiscount;
    // String image;
    
    
    
    
    @ManyToOne
    private Department department;
    public Product setDepartment(Department dep) {
        this.department = dep;
        return this;
    }


    @ManyToOne
    private Supplier supplier;
    public Product setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }


    @ManyToOne
    private Maker maker;
    public Product setMaker(Maker maker) {
        this.maker = maker;
        return this;
    }

    public Product( 
        String name, 
        String description, 
        int priceBig, 
        int priceSmall
    ){
        this.name = name;
        this.description = description;
        this.priceBig = priceBig;
        this.priceSmall = priceSmall;
    };




    public String getDepartmentName(){
        if( this.getDepartment() == null ) return "No Category";
        return this.getDepartment().getName();     
    }
    public String getSupplierName(){
        if( this.getSupplier() == null ) return "No Supplier";
        return this.getSupplier().getName();     
    }
    public String getMakerName(){
        if( this.getMaker() == null ) return "No Maker";
        return this.getMaker().getName();     
    }


    /**
     * 
     * @return
     */
    public String getPrice(){
        int euro = this.getPriceBig();
        int cent = this.getPriceSmall();
        String centStr =  ( Integer.valueOf(cent) == null ) ? "00" : cent + "" ;
        String euroStr =  ( Integer.valueOf(euro) == null ) ? "00" : euro + "" ;
        // return  Float.parseFloat(euroStr + "." + centStr);
        // return new BigDecimal( euroStr + "." + centStr );
        return euroStr + "." + centStr;
    }

}
