package be.heh.projet_java.adaptater.out.store;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "stores")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Please provide a name")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128")
    private String name;

    @Column(name = "address")
    @NotNull(message = "Please provide a address")
    private String address;

}