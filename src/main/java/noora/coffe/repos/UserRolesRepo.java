package noora.coffe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.UserRoles;


@Repository
public interface UserRolesRepo extends JpaRepository<UserRoles, Long> {}