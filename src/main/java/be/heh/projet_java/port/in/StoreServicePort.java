package be.heh.projet_java.port.in;

import be.heh.projet_java.model.Store;

import java.util.List;

public interface StoreServicePort {
    Store addStore(Store store);

    void deleteStoreById(Long id);

    Store updateStore(Long id, Store store);

    List<Store> getStores();

    Store getStoreById(Long storeId);

}
