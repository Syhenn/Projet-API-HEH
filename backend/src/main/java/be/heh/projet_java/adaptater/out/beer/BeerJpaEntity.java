package be.heh.projet_java.adaptater.out.beer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "beers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Please provide a name")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128")
    private String name;

    @Column(name = "url")
    @NotNull(message = "Please provide a url")
    private String url;

    @Column(name = "degrees")
    @Positive(message = "Degree need to be positive")
    @NotNull(message = "Please provide a degree")
    private Float degrees;
}
