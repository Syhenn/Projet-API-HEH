package be.heh.projet_java.adaptater.out.store;

import be.heh.projet_java.model.Store;
import be.heh.projet_java.port.out.StorePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import be.heh.projet_java.adaptater.out.store.StoreJpaEntity;
public class StorePersistenceAdaptater implements StorePersistencePort {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store addStore(Store store) {
        StoreJpaEntity storeJpaEntity = StoreMapper.INSTANCE.storeToStoreJpa(store);

        StoreJpaEntity storeSaved = storeRepository.save(storeJpaEntity);

        return StoreMapper.INSTANCE.storeJpaToStore(storeSaved);
    }
    @Override
    public void deleteStoreById(Long id) {
        storeRepository.deleteById(id);
    }
    @Override
    public Store updateStore(Store store) {
        return addStore(store);
    }

    @Override
    public List<Store> getStores() {
        List<StoreJpaEntity> storeList = storeRepository.findAll();
        return StoreMapper.INSTANCE.storeJpaListToStoreList(storeList);
    }

    @Override
    public Store getStoreById(Long storeId) {
        Optional<StoreJpaEntity> storeJpa = storeRepository.findById(storeId);

        if(storeJpa.isPresent()){
            return StoreMapper.INSTANCE.storeJpaToStore(storeJpa.get());
        }

        return null;
    }
}