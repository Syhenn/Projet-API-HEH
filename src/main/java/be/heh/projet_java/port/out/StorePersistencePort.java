package be.heh.projet_java.port.out;

import be.heh.projet_java.model.Store;

import java.util.List;

public interface StorePersistencePort {
    Store addStore(Store store);

    void deleteStoreById(Long id);

    Store updateStore(Store store);

    List<Store> getStores();

    Store getStoreById(Long storeId);
}
