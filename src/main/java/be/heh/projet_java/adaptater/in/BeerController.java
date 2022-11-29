package be.heh.projet_java.adaptater.in;

import be.heh.projet_java.model.Beer;
import be.heh.projet_java.port.in.BeerServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beer")
public class BeerController {

  @Autowired
  private BeerServicePort beerServicePort;

  @GetMapping("/{id}")
  public Beer getBeerById(@PathVariable Long id) {
    return beerServicePort.getBeerById(id);
  }

  @PutMapping("/update/{id}")
  public Beer updateBeer(@PathVariable Long id,@RequestBody Beer beer) {

    return beerServicePort.updateBeer(id, beer);
  }

  @GetMapping
  public List<Beer> getAllBeer(@RequestParam Long limit) {
    System.out.println(limit);
    return beerServicePort.getBeers();
  }

  @PostMapping
  public Beer addBeer(@RequestBody Beer beer) {
    return  beerServicePort.addBeer(beer);
  }

  @DeleteMapping("/{id}")
  public void deleteBeerById(@PathVariable Long id) {
    beerServicePort.deleteBeerById(id);
  }
}