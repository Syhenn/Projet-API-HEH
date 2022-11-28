package be.heh.projet_java.adaptater.out.wine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<WineJpaEntity, Long> {
}
