package be.heh.projet_java;

import be.heh.projet_java.adaptater.out.store.StoreMapper;
import be.heh.projet_java.adaptater.out.store.StorePersistenceAdaptater;
import be.heh.projet_java.adaptater.out.store.StoreRepository;
import be.heh.projet_java.model.Store;
import be.heh.projet_java.port.service.StoreServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistanceTest extends AbstractIntegrationTest{
    @Autowired
    private StoreRepository storeRepository;
    private StoreMapper storeMapper;

    private StorePersistenceAdaptater storePersistenceAdapter;

    @Test
    @Sql({"createStoreTable.sql","dataStore.sql"})
    void getStoresList(){
        storePersistenceAdapter = new StorePersistenceAdaptater();

        List<Store> stores;

        stores = storePersistenceAdapter.getStores();


        assertEquals("tata1",stores.get(1).getName());
        assertEquals("tutu1",stores.get(1).getAddress());
    }
}
