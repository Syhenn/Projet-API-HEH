package be.heh.projet_java.adaptater.out.wine;

import be.heh.projet_java.model.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface WineMapper {
    WineMapper INSTANCE = Mappers.getMapper(WineMapper.class);

    Wine wineToWineModel(WineJpaEntity wineJpaEntity);

    WineJpaEntity wineToWineJpaEntity(Wine wine);

    List<Wine> wineJpaEntityListToWineList(List<WineJpaEntity> wineJpaEntityList);

    List<Wine> wineJpaEntityPageToWineList(Page<WineJpaEntity> wineJpaEntityPage);
    List<WineJpaEntity> wineListToWineJpaEntityList (List<Wine> wineList);
}
