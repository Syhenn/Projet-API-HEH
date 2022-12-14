package be.heh.projet_java.adaptater.in;


import be.heh.projet_java.model.Wine;
import be.heh.projet_java.port.in.WineServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/wine")
public class WineController {
    @Autowired
    private WineServicePort wineServicePort;

    @GetMapping
    public List<Wine> getAllWine(@RequestParam(defaultValue = "100", required = false) int limit) {
        return wineServicePort.getWines(limit);
    }

    @GetMapping("/{id}")
    public Wine getWineById(@PathVariable Long id) {
        return wineServicePort.getWineById(id);
    }

    @PutMapping("/{id}")
    public Wine updateWine(@PathVariable Long id ,@RequestBody Wine wine) {
        return wineServicePort.updateWine(id, wine);
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

