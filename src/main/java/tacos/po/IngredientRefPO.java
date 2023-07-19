package tacos.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName IngredientRef.java
 * @createTime 2023/07/18 20:20
 */
@Data
@Table("INGREDIENT_REF")
public class IngredientRefPO {

    @Id
    private Long id;

    @Column
    private String ingredient;

    @Column
    private Long taco;

    @Column
    private Integer tacoKey;
}
