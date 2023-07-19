package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.TacoPO;

public interface TacoRepository extends CrudRepository<TacoPO, Long> {
}
