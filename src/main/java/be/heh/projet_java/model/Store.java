package be.heh.projet_java.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Store {

    private Long id;

    private final String name;

    private final String address;

}
