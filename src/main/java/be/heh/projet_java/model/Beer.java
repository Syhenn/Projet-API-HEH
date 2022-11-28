package be.heh.projet_java.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Beer {

  private Long id;

  private final String nameBeer;

  private final String url;

  private final float degrees;
}