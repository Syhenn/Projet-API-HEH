package be.heh.projet_java;

import be.heh.projet_java.adaptater.out.store.StoreMapper;
import be.heh.projet_java.adaptater.out.store.StorePersistenceAdaptater;
import be.heh.projet_java.adaptater.out.store.StoreRepository;
import be.heh.projet_java.port.in.StoreServicePort;
import be.heh.projet_java.port.out.StorePersistencePort;
import be.heh.projet_java.port.service.StoreServiceImpl;
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
    public StoreServicePort bookService(){
        return new StoreServiceImpl(storePersistence());
    }
}
