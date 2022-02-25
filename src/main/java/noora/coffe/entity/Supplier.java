package noora.coffe.entity;


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
public class Supplier extends AbstractPersistable<Long>{
    
    /**
     *  Сущность поставщика
     */
     String name;
     String contact;
     String email;


     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinColumn(name = "supplier_id")
     private List<Product> products;


}
