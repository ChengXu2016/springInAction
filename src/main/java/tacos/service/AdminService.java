package tacos.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import tacos.data.OrderRepository;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName AdminService.java
 * @createTime 2023/07/20 16:19
 */
@Service
public class AdminService {

    private OrderRepository orderRepository;

    public AdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
