package be.heh.projet_java.port.service;

import be.heh.projet_java.adaptater.out.beer.BeerJpaEntity;
import be.heh.projet_java.model.Beer;
import be.heh.projet_java.port.in.BeerServicePort;
import be.heh.projet_java.port.out.BeerPersistencePort;

import java.util.List;

public class BeerServiceImpl implements BeerServicePort {
    private BeerPersistencePort beerPersistencePort;

    public BeerServiceImpl(BeerPersistencePort beerPersistancePort) {
        this.beerPersistencePort = beerPersistancePort;
    }

    @Override
    public Beer addBeer(Beer beer) {
        return beerPersistencePort.addBeer(beer);
    }

    @Override
    public void deleteBeerById(Long id) {
        beerPersistencePort.deleteBeerById(id);
    }

    @Override
    public Beer updateBeer(Beer beer) {
        return beerPersistencePort.updateBeer(beer);
    }

    @Override
    public List<Beer> getBeers() {
        return beerPersistencePort.getBeers();
    }

    @Override
    public Beer getBeerById(Long beerId) {
        return beerPersistencePort.getBeerById(beerId);
    }

}
