package tacos.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tacos.data.IngredientRefRepository;
import tacos.data.OrderRepository;
import tacos.data.TacoRepository;
import tacos.po.IngredientRefPO;
import tacos.po.TacoOrderPO;
import tacos.po.TacoPO;
import tacos.pojo.IngredientRef;
import tacos.pojo.Taco;
import tacos.pojo.TacoOrder;

import java.util.List;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName OrderService.java
 * @createTime 2023/07/19 14:40
 */
@Service
public class OrderService {

    private OrderRepository orderRepository;
    private TacoRepository tacoRepository;
    private IngredientRefRepository ingredientRefRepository;

    public OrderService(OrderRepository orderRepository, TacoRepository tacoRepository, IngredientRefRepository ingredientRefRepository) {
        this.orderRepository = orderRepository;
        this.tacoRepository = tacoRepository;
        this.ingredientRefRepository = ingredientRefRepository;
    }

    public void saveOrder(TacoOrder order) {
        TacoOrderPO tacoOrderPO = new TacoOrderPO();
        BeanUtils.copyProperties(order, tacoOrderPO);
        orderRepository.save(tacoOrderPO);
        List<Taco> tacos = order.getTacos();
        int i = 0;
        for (Taco taco : tacos) {
            saveTaco(tacoOrderPO.getId(), i++, taco);
        }
    }

    private void saveTaco(Long orderId, int orderKey, Taco taco) {
        TacoPO tacoPO = new TacoPO();
        BeanUtils.copyProperties(taco, tacoPO);
        tacoPO.setTacoOrder(orderId);
        tacoPO.setTacoOrderKey(orderKey);
        tacoRepository.save(tacoPO);

        saveIngredientRefs(tacoPO.getId(), taco.getIngredientRefs());
    }

    private void saveIngredientRefs(Long id, List<IngredientRef> ingredientRefs) {

        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            IngredientRefPO ingredientRefPO = new IngredientRefPO();
            BeanUtils.copyProperties(ingredientRef, ingredientRefPO);
            ingredientRefPO.setTaco(id);
            ingredientRefPO.setTacoKey(key++);
            ingredientRefRepository.save(ingredientRefPO);
        }
    }
}
