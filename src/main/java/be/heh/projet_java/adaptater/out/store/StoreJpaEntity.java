package be.heh.projet_java.adaptater.out.store;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "stores")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_store")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

}