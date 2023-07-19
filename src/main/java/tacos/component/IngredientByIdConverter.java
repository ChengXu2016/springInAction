package tacos.component;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.data.IngredientRepository;
import tacos.pojo.Ingredient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName IngredientByIdConverter.java
 * @createTime 2023/07/18 13:18
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        /*ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("COTO", new Ingredient("COTO", "COTO Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
        ingredientMap.put("CRAN", new Ingredient("CRAN", "Carnitas", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
        ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));*/
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
//        return ingredientMap.get(id);
        return ingredientRepository.findById(id).orElse(null);
    }
}
