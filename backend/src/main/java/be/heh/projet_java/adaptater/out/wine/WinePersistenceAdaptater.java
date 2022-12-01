package be.heh.projet_java.adaptater.out.wine;


import be.heh.projet_java.adaptater.out.beer.BeerJpaEntity;
import be.heh.projet_java.adaptater.out.beer.BeerMapper;
import be.heh.projet_java.adaptater.out.store.StoreJpaEntity;
import be.heh.projet_java.adaptater.out.store.StoreMapper;
import be.heh.projet_java.model.Beer;
import be.heh.projet_java.model.Wine;
import be.heh.projet_java.port.out.WinePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class WinePersistenceAdaptater implements WinePersistencePort {
    @Autowired
    private WineRepository wineRepository;
    @Override
    public Wine addWine(Wine wine) {
        WineJpaEntity wineJpaEntity = WineMapper.INSTANCE.wineToWineJpaEntity(wine);
        WineJpaEntity wineJpaEntitySaved = wineRepository.save(wineJpaEntity);
        return WineMapper.INSTANCE.wineToWineModel(wineJpaEntitySaved);
    }

    @Override
    public void deleteWineById(Long id) {
        wineRepository.deleteById(id);
    }

    @Override
    public Wine updateWine(Long id, Wine wine) {
        Optional<WineJpaEntity> wineJpa = wineRepository.findById(id);

        if (wineJpa.isPresent()) {
            Wine wine_by_id = WineMapper.INSTANCE.wineToWineModel(wineJpa.get());
            WineJpaEntity wineJpaEntity = WineMapper.INSTANCE.wineToWineJpaEntity(wine);
            wineJpaEntity.setId(id);
            if (wine_by_id.getName() != wineJpaEntity.getName()) {
                wineJpaEntity.setName(wine.getName());
            } else if (wine_by_id.getDegrees() != wineJpaEntity.getDegrees()) {
                wineJpaEntity.setDegrees(wine.getDegrees());
            } else if (wine_by_id.getUrl() != wineJpaEntity.getUrl()) {
                wineJpaEntity.setUrl(wine.getUrl());
            }
            WineJpaEntity wineSaved = wineRepository.save(wineJpaEntity);
            return WineMapper.INSTANCE.wineToWineModel(wineSaved);
        }
        return null;
    }

    @Override
    public List<Wine> getWines(int limit) {
        Pageable paging = PageRequest.of(0,limit, Sort.by("id"));
        if(limit > 0) {
            Page<WineJpaEntity> pagedResult = wineRepository.findAll(paging);
            return WineMapper.INSTANCE.wineJpaEntityPageToWineList(pagedResult);
        } else {
        List<WineJpaEntity> wineJpaEntityList = wineRepository.findAll();
        return WineMapper.INSTANCE.wineJpaEntityListToWineList(wineJpaEntityList);
        }
    }

    @Override
    public Wine getWineById(Long wineId) {
        Optional<WineJpaEntity> wineJpaEntity = wineRepository.findById(wineId);

        if(wineJpaEntity.isPresent()) {
            return WineMapper.INSTANCE.wineToWineModel(wineJpaEntity.get());
        }
        return null;
    }
}
