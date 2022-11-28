package be.heh.projet_java.adaptater.out.beer;

import be.heh.projet_java.model.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeerMapper {
    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer beerToBeerModel(BeerJpaEntity beerJpaEntity);

    BeerJpaEntity beerToBeerJpaEntity(Beer beer);

    List<Beer> beerJpaEntityListToBeerList(List<BeerJpaEntity> beerJpaEntityList);

    List<BeerJpaEntity> beerListToBeerJpaEntityList (List<Beer> beerList);
}
