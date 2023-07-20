package tacos.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName UserPO.java
 * @createTime 2023/07/19 23:00
 */
@Table("TACO_USER")
@Data
public class UserPO {

    @Id
    private Long id;

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
}
