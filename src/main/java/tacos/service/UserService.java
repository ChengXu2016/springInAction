package tacos.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tacos.data.UserRepository;
import tacos.po.UserPO;
import tacos.pojo.User;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName UserService.java
 * @createTime 2023/07/20 08:17
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        UserPO userPO = userRepository.findByUsername(username);
        return userPO == null ? null : toUser(userPO);
    }

    private User toUser(UserPO userPO) {
        User user = new User(userPO.getUsername(), userPO.getPassword(),
                userPO.getFullname(), userPO.getStreet(), userPO.getStreet(),
                userPO.getState(), userPO.getZip(), userPO.getPhoneNumber());
        user.setId(userPO.getId());
        return user;
    }

    public void save(User user) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user, userPO);
        userRepository.save(userPO);
    }
}
