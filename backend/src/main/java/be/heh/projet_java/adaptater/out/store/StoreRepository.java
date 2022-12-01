package be.heh.projet_java.adaptater.out.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreJpaEntity, Long> {
    Page<StoreJpaEntity> findAll(Pageable pageable);
}
