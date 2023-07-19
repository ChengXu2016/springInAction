package tacos.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName Taco.java
 * @createTime 2023/07/17 22:46
 */
@Data
@Table("TACO")
public class TacoPO {

    @Id
    private Long id;

    @Column
    private Date createdAt;

    @Column
    private String name;

    @Column
    private Long tacoOrder;

    @Column
    private Integer tacoOrderKey;
}
