package be.heh.projet_java.adaptater.out.beer;

import be.heh.projet_java.model.Beer;
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
    public Beer updateBeer(Beer beer) {
        return addBeer(beer);
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
