package be.heh.projet_java.adaptater.in;

import be.heh.projet_java.model.Store;
import be.heh.projet_java.port.in.StoreServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreServicePort storeServicePort;

    @PostMapping()
    public Store addStore(@RequestBody Store store){
        return storeServicePort.addStore(store);
    }
    @GetMapping()
    public List<Store> getAllStore(@RequestParam(defaultValue = "100", required = false) int limit) {
        return storeServicePort.getStores(limit);
    }
    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable long id){
        return storeServicePort.getStoreById(id);
    }

    @PutMapping("/{id}")
    public Store updateStore(@PathVariable long id, @RequestBody Store store) {

        return storeServicePort.updateStore(id, store);
    }

    @DeleteMapping("/{id}")
    public void deleteStoreById(@PathVariable long id){
        storeServicePort.deleteStoreById(id);
    }
}
