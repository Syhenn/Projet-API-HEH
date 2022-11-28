package be.heh.projet_java.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Beer {
  @Getter
  @Setter
  private final String nameBeer;

  @Getter
  @Setter
  private final String url;

  @Getter
  @Setter
  private final float degrees;
}