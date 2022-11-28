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
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreServicePort storeServicePort;

    @PostMapping("/add")
    public Store addStore(@RequestBody Store store){
        return storeServicePort.addStore(store);
    }
    @GetMapping()
    public List<Store> getAllstore() {
        //return "storeList";
        System.out.println(storeServicePort.getStores());
        return storeServicePort.getStores();
    }
    @GetMapping("/get/{id}")
    public Store getStoreById(@PathVariable long id){
        return storeServicePort.getStoreById(id);
    }
    @PutMapping("/update/{id}")
    public Store updateStore(@RequestBody Store store) {
        return storeServicePort.updateStore(store);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStoreById(@PathVariable long id){
        storeServicePort.deleteStoreById(id);
    }
}
