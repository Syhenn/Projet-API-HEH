package be.heh.projet_java.adaptater.out.beer;

import be.heh.projet_java.adaptater.out.store.StoreJpaEntity;
import be.heh.projet_java.adaptater.out.store.StoreMapper;
import be.heh.projet_java.model.Beer;
import be.heh.projet_java.model.Store;
import be.heh.projet_java.port.out.BeerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BeerPersistenceAdaptater implements BeerPersistencePort {

    @Autowired
    private BeerRepository beerRepository;

    @Override
    public Beer addBeer(Beer beer) {
        BeerJpaEntity beerJpaEntity = BeerMapper.INSTANCE.beerToBeerJpaEntity(beer);
        BeerJpaEntity bookJpaEntitySaved = beerRepository.save(beerJpaEntity);
        return BeerMapper.INSTANCE.beerToBeerModel(bookJpaEntitySaved);
    }

    @Override
    public void deleteBeerById(Long id) {
        beerRepository.deleteById(id);
    }

    @Override
    public Beer updateBeer(Long id, Beer beer) {

        Optional<BeerJpaEntity> beerJpa = beerRepository.findById(id);

        if (beerJpa.isPresent()) {
            Beer beer_by_id = BeerMapper.INSTANCE.beerToBeerModel(beerJpa.get());
            BeerJpaEntity beerJpaEntity = BeerMapper.INSTANCE.beerToBeerJpaEntity(beer);
            beerJpaEntity.setId(id);
            if (beer_by_id.getNameBeer() != beerJpaEntity.getNameBeer()) {
                beerJpaEntity.setNameBeer(beer.getNameBeer());
            } else if (beer_by_id.getDegrees() != beerJpaEntity.getDegrees()) {
                beerJpaEntity.setDegrees(beer.getDegrees());
            } else if (beer_by_id.getUrl() != beerJpaEntity.getUrl()) {
                beerJpaEntity.setUrl(beer.getUrl());
            }
            BeerJpaEntity beerSaved = beerRepository.save(beerJpaEntity);
            return BeerMapper.INSTANCE.beerToBeerModel(beerSaved);
        }
        return null;
    }

    @Override
    public List<Beer> getBeers() {
        List<BeerJpaEntity> beerJpaEntityList = beerRepository.findAll();

        return BeerMapper.INSTANCE.beerJpaEntityListToBeerList(beerJpaEntityList);
    }

    @Override
    public Beer getBeerById(Long beerId) {
        Optional<BeerJpaEntity> beerJpaEntity = beerRepository.findById(beerId);

        if(beerJpaEntity.isPresent()) {
            return BeerMapper.INSTANCE.beerToBeerModel(beerJpaEntity.get());
        }
        return null;
    }

}
