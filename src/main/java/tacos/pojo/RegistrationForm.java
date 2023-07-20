package tacos.pojo;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName RegistrationForm.java
 * @createTime 2023/07/20 08:33
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder encoder) {

        return new User(username, encoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}
