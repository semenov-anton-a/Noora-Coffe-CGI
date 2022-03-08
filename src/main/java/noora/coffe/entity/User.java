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
// @NoArgsConstructor
// @AllArgsConstructor
public class User extends AbstractPersistable<Long> {
    
   
    // @Id
    // @GeneratedValue(String string, String string2strategy = GenerationType.TABLE)
    // private Long id;
    @Column(unique=true)
    private String email;
    
    private String password;
    
    // @Transient User currentUser;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRoles> roles;
    



    /**
     * Constr
     * @param email
     * @param password
     */
    public User( String email, String password ) {
        this.email = email;
        this.password = password;    
    }





}
