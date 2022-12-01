package be.heh.projet_java.adaptater.out.store;

import be.heh.projet_java.adaptater.out.beer.BeerJpaEntity;
import be.heh.projet_java.adaptater.out.beer.BeerMapper;
import be.heh.projet_java.model.Store;
import be.heh.projet_java.port.out.StorePersistencePort;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import be.heh.projet_java.adaptater.out.store.StoreJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
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
    public Store updateStore(Long id, Store store) {
        Optional<StoreJpaEntity> storeJpa = storeRepository.findById(id);

        if(storeJpa.isPresent()){
            Store store_by_id = StoreMapper.INSTANCE.storeJpaToStore(storeJpa.get());
            StoreJpaEntity storeJpaEntity = StoreMapper.INSTANCE.storeToStoreJpa(store);
            storeJpaEntity.setId(id);
            if(store_by_id.getAddress() != storeJpaEntity.getAddress()){
                storeJpaEntity.setAddress(store.getAddress());
            }else if(store_by_id.getName() != storeJpaEntity.getName()){
                storeJpaEntity.setName(store.getName());
            }
            StoreJpaEntity storeSaved = storeRepository.save(storeJpaEntity);
            return StoreMapper.INSTANCE.storeJpaToStore(storeSaved);
        }

        return null;
    }

    @Override
    public List<Store> getStores(int limit) {
        Pageable paging = PageRequest.of(0,limit, Sort.by("id"));
        if(limit > 0) {
            Page<StoreJpaEntity> pagedResult = storeRepository.findAll(paging);
            return StoreMapper.INSTANCE.storeJpaEntityPageToStoreList(pagedResult);
        } else {
            List<StoreJpaEntity> storeList = storeRepository.findAll();
            return StoreMapper.INSTANCE.storeJpaListToStoreList(storeList);
        }
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
