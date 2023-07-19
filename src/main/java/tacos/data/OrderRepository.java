package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.TacoOrderPO;

public interface OrderRepository extends CrudRepository<TacoOrderPO, Long> {
}
