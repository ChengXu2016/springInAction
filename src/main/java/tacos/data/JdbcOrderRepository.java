package tacos.data;

import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tacos.pojo.IngredientRef;
import tacos.pojo.Taco;
import tacos.pojo.TacoOrder;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName JdbcOrderRepository.java
 * @createTime 2023/07/18 20:20
 */
@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public TacoOrder save(TacoOrder order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Taco_Order " + "(delivery_Name,delivery_Street,delivery_City,"
                        + "delivery_State,delivery_Zip,cc_number,cc_expiration,cc_cvv,placed_at) "
                        + "values (?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR);
        pscf.setReturnGeneratedKeys(true);

        order.setPlacedAt(new Timestamp(new Date().getTime()));
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(
                order.getDeliveryName(), order.getDeliveryStreet(), order.getDeliveryCity(),
                order.getDeliveryState(), order.getDeliveryZip(), order.getCcNumber(),
                order.getCcExpiration(), order.getCcCVV(), order.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Taco> tacos = order.getTacos();
        int i = 0;
        for (Taco taco : tacos) {
            saveTaco(orderId, i++, taco);
        }
        return order;
    }

    private long saveTaco(long orderId, int orderKey, Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Taco "
                        + "(name, taco_order, taco_order_key, created_at) "
                        + "values(?, ?, ?, ?)",
                Types.VARCHAR, Type.LONG, Type.LONG, Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(
                taco.getName(),
                orderId,
                orderKey,
                taco.getCreatedAt())
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);

        saveIngredientRefs(tacoId, taco.getIngredientRefs());

        return tacoId;
    }

    private void saveIngredientRefs(long tacoId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update("insert into Ingredient_Ref (ingredient, taco, taco_key) "
                    + "values (?, ?, ?)", ingredientRef.getIngredient(), tacoId, key++);
        }
    }


}
