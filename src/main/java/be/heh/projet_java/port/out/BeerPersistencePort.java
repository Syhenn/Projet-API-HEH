package be.heh.projet_java.port.out;

import java.util.List;

import be.heh.projet_java.adaptater.out.beer.BeerJpaEntity;
import be.heh.projet_java.model.Beer;

public interface BeerPersistencePort {
    Beer addBeer(Beer beer);
    void deleteBeerById(Long id);
    Beer updateBeer(Long id,Beer beer);
    List<Beer> getBeers();
    Beer getBeerById(Long beer);
}
