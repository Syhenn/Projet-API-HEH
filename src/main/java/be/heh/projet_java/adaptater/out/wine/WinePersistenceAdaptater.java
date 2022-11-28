package be.heh.projet_java.adaptater.out.wine;


import be.heh.projet_java.model.Wine;
import be.heh.projet_java.port.out.WinePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Wine updateWine(Wine wine) {
        return addWine(wine);
    }

    @Override
    public List<Wine> getWines() {
        List<WineJpaEntity> wineJpaEntityList = wineRepository.findAll();

        return WineMapper.INSTANCE.wineJpaEntityListToWineList(wineJpaEntityList);
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
