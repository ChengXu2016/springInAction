package tacos.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName Taco.java
 * @createTime 2023/07/17 22:46
 */
@Data
public class Taco {

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    public List<IngredientRef> getIngredientRefs() {
        return ingredients
                .stream()
                .map(item -> new IngredientRef(item.getId()))
                .collect(Collectors.toList());
    }
}
