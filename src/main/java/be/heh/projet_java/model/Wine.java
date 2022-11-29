package be.heh.projet_java.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Wine {

    private Long id;

    private final String name;

    private final String url;

    private final float degrees;
}