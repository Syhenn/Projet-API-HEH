package be.heh.projet_java;

import be.heh.projet_java.adaptater.out.store.StorePersistenceAdaptater;
import be.heh.projet_java.model.Store;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class AdaptaterWebTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorePersistenceAdaptater storePersistenceAdaptaters;

    private List<Store> stores = new ArrayList<>();

    @Test
    public void testStoreController() throws Exception {

        stores.add(new Store(1L,"tata","titi"));
        stores.add(new Store(2L,"tata1","titi1"));
        System.out.println(storePersistenceAdaptaters.getStores(10));
        //Stub
        Mockito.when(storePersistenceAdaptaters.getStores(10)).thenReturn(stores);

        mockMvc.perform(get("/store"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("stores"))
                .andExpect(model().attribute("stores", Matchers.hasSize(3)));
    }
}
