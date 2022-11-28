package be.heh.projet_java.adaptater.in;


import be.heh.projet_java.model.Wine;
import be.heh.projet_java.port.in.WineServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wine")
public class WineController {
    @Autowired
    private WineServicePort wineServicePort;

    @GetMapping
    public List<Wine> getAllBooks() {
        return wineServicePort.getWines();
    }

    @GetMapping("/{id}")
    public Wine getWineById(@PathVariable Long id) {
        return wineServicePort.getWineById(id);
    }

    @PutMapping()
    public Wine updateWine(@RequestBody Wine wine) {
        return wineServicePort.updateWine(wine);
    }
    @PostMapping
    public Wine addWine(@RequestBody Wine wine) {
        return  wineServicePort.addWine(wine);
    }

    @DeleteMapping("/{id}")
    public void deleteWineById(@PathVariable Long id) {
        wineServicePort.deleteWineById(id);
    }
}

