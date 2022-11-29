package be.heh.projet_java.port.in;

import be.heh.projet_java.model.Beer;

import java.util.List;

public interface BeerServicePort {
  Beer addBeer(Beer beer);
  void deleteBeerById(Long id);
  Beer updateBeer(Long id,Beer beer);
  List<Beer> getBeers(int limit);
  Beer getBeerById(Long beer);

}