package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.IngredientRefPO;

public interface IngredientRefRepository extends CrudRepository<IngredientRefPO, Long> {
}
