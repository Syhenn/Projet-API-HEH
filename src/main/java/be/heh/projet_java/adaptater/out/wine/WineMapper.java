package be.heh.projet_java.adaptater.out.wine;

import be.heh.projet_java.adaptater.out.beer.BeerJpaEntity;
import be.heh.projet_java.adaptater.out.beer.BeerMapper;
import be.heh.projet_java.model.Beer;
import be.heh.projet_java.model.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WineMapper {
    WineMapper INSTANCE = Mappers.getMapper(WineMapper.class);

    Wine wineToWineModel(WineJpaEntity wineJpaEntity);

    WineJpaEntity wineToWineJpaEntity(Wine wine);

    List<Wine> wineJpaEntityListToWineList(List<WineJpaEntity> wineJpaEntityList);

    List<WineJpaEntity> wineListToWineJpaEntityList (List<Wine> wineList);
}
