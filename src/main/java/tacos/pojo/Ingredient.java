package tacos.pojo;

import lombok.Data;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName Ingredient.java
 * @createTime 2023/07/17 22:40
 */
@Data
public class Ingredient {

    private final String id;

    private final String name;

    private final Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE;
    }
}
