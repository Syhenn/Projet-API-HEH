package be.heh.projet_java.port.in;

import be.heh.projet_java.model.Wine;

import java.util.List;

public interface WineServicePort {
    Wine addWine(Wine wine);
    void deleteWineById(Long id);

    Wine updateWine(Long id,Wine wine);
    List<Wine> getWines(int limit);
    Wine getWineById(Long wine);
}
