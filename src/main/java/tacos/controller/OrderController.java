package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.data.OrderRepository;
import tacos.pojo.TacoOrder;
import tacos.pojo.User;
import tacos.service.OrderService;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName OrderController.java
 * @createTime 2023/07/18 12:43
 */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderService orderService;

    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               @AuthenticationPrincipal User user,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();*/


        log.info("Order submitted: {}", order);
        order.setUser(user);
        order.setPlacedAt(new Date());
//        orderRepository.save(order);
        orderService.saveOrder(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
