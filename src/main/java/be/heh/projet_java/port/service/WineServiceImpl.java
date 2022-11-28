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
    public Wine updateWine(Wine wine) {
        return  winePersistencePort.updateWine(wine);
    }

    @Override
    public List<Wine> getWines() {
        return winePersistencePort.getWines();
    }

    @Override
    public Wine getWineById(Long wineId) {
        return winePersistencePort.getWineById(wineId);
    }

}
