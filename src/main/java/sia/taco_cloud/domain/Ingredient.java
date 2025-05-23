package sia.taco_cloud.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import org.springframework.data.domain.Persistable;


@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private final String id;
    private final String name;
    private final Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
