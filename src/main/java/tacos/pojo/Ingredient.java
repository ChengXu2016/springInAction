package tacos.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName Ingredient.java
 * @createTime 2023/07/17 22:40
 */
@Table
@Data
public class Ingredient {

    @Id
    private final String id;

    @Column
    private final String name;

    @Column
    private final Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE;
    }
}
