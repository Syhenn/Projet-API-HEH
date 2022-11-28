package be.heh.projet_java.port.service;

import be.heh.projet_java.model.Store;
import be.heh.projet_java.port.in.StoreServicePort;
import be.heh.projet_java.port.out.StorePersistencePort;

import java.util.List;

public class StoreServiceImpl implements StoreServicePort {
    private StorePersistencePort storePersistencePort;

    public StoreServiceImpl(StorePersistencePort storePersistencePort){
        this.storePersistencePort = storePersistencePort;
    }

    @Override
    public Store addStore(Store store){
        return storePersistencePort.addStore(store);
    }

    @Override
    public void deleteStoreById(Long id){
        storePersistencePort.deleteStoreById(id);
    }

    @Override
    public Store updateStore(Store store){
        return storePersistencePort.updateStore(store);
    }

    @Override
    public List<Store> getStores(){
        return storePersistencePort.getStores();
    }

    @Override
    public Store getStoreById(Long storeId){
        return storePersistencePort.getStoreById(storeId);
    }
}
