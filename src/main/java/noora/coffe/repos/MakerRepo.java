package noora.coffe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import noora.coffe.entity.Maker;

public interface MakerRepo extends JpaRepository<Maker, Long> {
}
