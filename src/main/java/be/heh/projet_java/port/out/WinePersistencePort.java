package be.heh.projet_java.port.out;

import be.heh.projet_java.model.Wine;

import java.util.List;

public interface WinePersistencePort {
    Wine addWine(Wine wine);
    void deleteWineById(Long id);
    Wine updateWine(Wine wine);
    List<Wine> getWines();
    Wine getWineById(Long wine);
}
