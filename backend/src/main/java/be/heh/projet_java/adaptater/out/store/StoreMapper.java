package be.heh.projet_java.adaptater.out.store;

import be.heh.projet_java.model.Store;

import java.util.ArrayList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    Store storeJpaToStore(StoreJpaEntity storeJpaEntity);

    StoreJpaEntity storeToStoreJpa(Store store);

    List<Store> storeJpaListToStoreList(List<StoreJpaEntity> storeJpaEntityList);

    List<Store> storeJpaEntityPageToStoreList(Page<StoreJpaEntity> storeJpaEntityPage);

    List<StoreJpaEntity> storeListToStoreJpa(List<Store> storeList);


}
