package noora.coffe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noora.coffe.entity.Maker;

@Repository
public interface MakerRepo extends JpaRepository<Maker, Long> {

    Maker findByName( String name );
    Boolean existsByName( String name );
    List<Maker> findAllById(Long id);
}
