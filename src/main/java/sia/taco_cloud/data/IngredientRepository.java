package sia.taco_cloud.data;

import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.domain.Ingredient;

import java.util.Optional;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {


}
