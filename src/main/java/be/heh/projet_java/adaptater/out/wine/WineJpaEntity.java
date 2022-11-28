package be.heh.projet_java.adaptater.out.wine;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wines")
public class WineJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameWine")
    private String nameBeer;

    @Column(name = "url")
    private String url;

    @Column(name = "degrees")
    private float degrees;
}
