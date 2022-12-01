package be.heh.projet_java.adaptater.out.beer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<BeerJpaEntity, Long> {
    Page<BeerJpaEntity> findAll(Pageable pageable);
}
