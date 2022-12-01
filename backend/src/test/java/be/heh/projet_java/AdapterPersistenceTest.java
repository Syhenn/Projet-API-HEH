package be.heh.projet_java;

import be.heh.projet_java.adaptater.out.beer.BeerPersistenceAdaptater;
import be.heh.projet_java.adaptater.out.beer.BeerRepository;
import be.heh.projet_java.adaptater.out.store.StoreJpaEntity;
import be.heh.projet_java.adaptater.out.store.StoreMapper;
import be.heh.projet_java.adaptater.out.store.StorePersistenceAdaptater;
import be.heh.projet_java.adaptater.out.store.StoreRepository;
import be.heh.projet_java.adaptater.out.wine.WinePersistenceAdaptater;
import be.heh.projet_java.adaptater.out.wine.WineRepository;
import be.heh.projet_java.model.Beer;
import be.heh.projet_java.model.Store;
import be.heh.projet_java.model.Wine;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistenceTest extends AbstractIntegrationTest{
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private WineRepository wineRepository;
    @Test
    @Sql({"createStoreTable.sql","dataStore.sql"})
    void getStores() {

        StorePersistenceAdaptater storePersistenceAdaptater = new StorePersistenceAdaptater(storeRepository );

        List<Store> stores = storePersistenceAdaptater.getStores(10);
        // Test name of the first data in store
        assertEquals("Colruyt Morlanwlez",stores.get(0).getName());

        // Test name of the second data in store
        assertEquals("Carrefour",stores.get(1).getName());
    }

    @Test
    @Sql({"createBeerTable.sql","dataBeer.sql"})
    void getBeers() {

        BeerPersistenceAdaptater beerPersistenceAdaptater = new BeerPersistenceAdaptater(beerRepository);

        List<Beer> beers = beerPersistenceAdaptater.getBeers(10);
        // Test name of the first data in beer
        assertEquals("Jupiler",beers.get(0).getName());

        // Test name of the second data in beer
        assertEquals("Kasteel",beers.get(1).getName());
    }

    @Test
    @Sql({"createWineTable.sql","dataWine.sql"})
    void getWine() {

        WinePersistenceAdaptater winePersistenceAdaptater = new WinePersistenceAdaptater(wineRepository);

        List<Wine> wines = winePersistenceAdaptater.getWines(10);
        // Test name of the first data in wine
        assertEquals("Jacob s creek",wines.get(0).getName());

        // Test name of the second data in wine
        assertEquals("Grand Barossa",wines.get(1).getName());
    }
}
