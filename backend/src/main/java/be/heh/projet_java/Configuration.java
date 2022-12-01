package be.heh.projet_java;

import be.heh.projet_java.adaptater.out.beer.BeerPersistenceAdaptater;
import be.heh.projet_java.adaptater.out.store.StoreMapper;
import be.heh.projet_java.adaptater.out.store.StorePersistenceAdaptater;
import be.heh.projet_java.adaptater.out.store.StoreRepository;
import be.heh.projet_java.adaptater.out.wine.WinePersistenceAdaptater;
import be.heh.projet_java.port.in.BeerServicePort;
import be.heh.projet_java.port.in.StoreServicePort;
import be.heh.projet_java.port.in.WineServicePort;
import be.heh.projet_java.port.out.BeerPersistencePort;
import be.heh.projet_java.port.out.StorePersistencePort;
import be.heh.projet_java.port.out.WinePersistencePort;
import be.heh.projet_java.port.service.BeerServiceImpl;
import be.heh.projet_java.port.service.StoreServiceImpl;
import be.heh.projet_java.port.service.WineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Bean
    public StorePersistencePort storePersistence(){
        return new StorePersistenceAdaptater();
    }

    @Bean
    public StoreServicePort storeService(){
        return new StoreServiceImpl(storePersistence());
    }

    @Bean
    public BeerPersistencePort beerPersistence(){
        return new BeerPersistenceAdaptater();
    }

    @Bean
    public BeerServicePort beerService(){
        return new BeerServiceImpl(beerPersistence());
    }

    @Bean
    public WinePersistencePort winePersistence(){
        return new WinePersistenceAdaptater();
    }

    @Bean
    public WineServicePort wineService(){
        return new WineServiceImpl(winePersistence());
    }
}
