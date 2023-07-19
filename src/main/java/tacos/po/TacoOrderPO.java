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
 * @ClassName TacoOrderPO.java
 * @createTime 2023/07/19 14:54
 */
@Data
@Table("TACO_ORDER")
public class TacoOrderPO {

    @Id
    private Long id;

    @Column
    private Date placedAt;

    @Column
    private String deliveryName;

    @Column
    private String deliveryStreet;

    @Column
    private String deliveryCity;

    @Column
    private String deliveryState;

    @Column
    private String deliveryZip;

    @Column
    private String ccNumber;

    @Column
    private String ccExpiration;

    @Column
    private String ccCVV;
}
