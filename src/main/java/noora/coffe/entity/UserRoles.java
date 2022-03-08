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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
// @AllArgsConstructor
public class UserRoles extends AbstractPersistable<Long> {
    

    public UserRoles(String account) {
    }




    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    public String role;

    @ManyToOne
    private User user;



    

}
