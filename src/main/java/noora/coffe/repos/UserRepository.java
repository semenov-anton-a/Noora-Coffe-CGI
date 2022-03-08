package noora.coffe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);}