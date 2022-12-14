package be.heh.projet_java.port.service;

import be.heh.projet_java.model.Wine;
import be.heh.projet_java.port.in.WineServicePort;
import be.heh.projet_java.port.out.WinePersistencePort;

import java.util.List;

public class WineServiceImpl implements WineServicePort {
    private WinePersistencePort winePersistencePort;

    public WineServiceImpl(WinePersistencePort winePersistencePort) {

        this.winePersistencePort = winePersistencePort;
    }

    @Override
    public Wine addWine(Wine wine) {
        return winePersistencePort.addWine(wine);
    }

    @Override
    public void deleteWineById(Long id) {
        winePersistencePort.deleteWineById(id);
    }

    @Override
    public Wine updateWine(Long id,Wine wine) {
        return  winePersistencePort.updateWine(id, wine);
    }

    @Override
    public List<Wine> getWines(int limit) {

        return winePersistencePort.getWines(limit);
    }

    @Override
    public Wine getWineById(Long wineId) {
        return winePersistencePort.getWineById(wineId);
    }

}
