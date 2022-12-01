package be.heh.projet_java;

import be.heh.projet_java.adaptater.in.BeerController;
import be.heh.projet_java.adaptater.in.StoreController;
import be.heh.projet_java.adaptater.in.WineController;
import be.heh.projet_java.model.Beer;
import be.heh.projet_java.model.Store;
import be.heh.projet_java.model.Wine;
import be.heh.projet_java.port.in.BeerServicePort;
import be.heh.projet_java.port.in.StoreServicePort;
import be.heh.projet_java.port.in.WineServicePort;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

//@RunWith(SpringRunner.class)
@WebMvcTest({StoreController.class,BeerController.class, WineController.class})
public class AdaptaterWebTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StoreServicePort storeServicePort;

    @MockBean
    BeerServicePort beerServicePort;

    @MockBean
    WineServicePort wineServicePort;

    private List<Store> stores = new ArrayList<>();
    private List<Beer> beers = new ArrayList<>();
    private List<Wine> wines = new ArrayList<>();


    @Test
    public void testStoreController() throws Exception {
        stores.add(new Store(1L,"Colryut","Colryut"));

        //Stub
        Mockito.when(storeServicePort.getStores(10)).thenReturn(stores);

        // Get All
        mockMvc.perform(get("/store"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Get All with limit
        mockMvc.perform(get("/store?limit=2"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Get a specific with id
        mockMvc.perform(get("/store/1"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Post
        mockMvc.perform(MockMvcRequestBuilders
                .post("/store")
                .content(asJsonString(new Store(2L, "Carrefour", "Carrefour")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // Delete
        mockMvc.perform(delete("/store/1"))
                .andExpect(status().isOk());

        // Put
        mockMvc.perform(put("/store/2")
                        .content(asJsonString(new Store(2L, "Change", "Changement")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testBeerController() throws Exception {
        beers.add(new Beer(1L,"Colryut","https://test.com/test.jpg", 9));

        //Stub
        Mockito.when(beerServicePort.getBeers(10)).thenReturn(beers);

        // Get All
        mockMvc.perform(get("/beer"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Get All with limit
        mockMvc.perform(get("/beer?limit=2"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Get a specific with id
        mockMvc.perform(get("/beer/1"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Post
        mockMvc.perform(MockMvcRequestBuilders
                .post("/beer")
                .content(asJsonString(new Beer(2L, "Carrefour", "https://test.com/test.png", 9)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // Delete
        mockMvc.perform(delete("/beer/1"))
                .andExpect(status().isOk());

        // Put
        mockMvc.perform(put("/beer/2")
                        .content(asJsonString(new Beer(2L, "Colryut", "https://test.com/salut.png", 7)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testWineController() throws Exception {
        wines.add(new Wine(1L,"Colryut","https://test.com/test.jpg", 9));

        //Stub
        Mockito.when(wineServicePort.getWines(10)).thenReturn(wines);

        // Get All
        mockMvc.perform(get("/wine"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Get All with limit
        mockMvc.perform(get("/wine?limit=2"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Get a specific with id
        mockMvc.perform(get("/wine/1"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

        // Post
        mockMvc.perform(MockMvcRequestBuilders
                .post("/wine")
                .content(asJsonString(new Wine(2L, "Carrefour", "https://test.com/test.png", 9)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // Delete
        mockMvc.perform(delete("/wine/1"))
                .andExpect(status().isOk());

        // Put
        mockMvc.perform(put("/wine/2")
                        .content(asJsonString(new Wine(2L, "Colryut", "https://test.com/salut.png", 7)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
