package be.heh.projet_java.adaptater.out.beer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "beers")
public class BeerJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameBeer")
    private String nameBeer;

    @Column(name = "url")
    private String url;

    @Column(name = "degrees")
    private float degrees;
}
