package triana.salesianos.dam.TrianaTourist.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class POI {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID id;

    private String location;

    @Lob
    private String description;

    private LocalDate date;

    @ManyToOne
    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

}
