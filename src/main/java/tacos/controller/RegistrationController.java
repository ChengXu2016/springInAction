package tacos.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.pojo.RegistrationForm;
import tacos.service.UserService;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName RegistrationController.java
 * @createTime 2023/07/20 08:29
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {


    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userService.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
