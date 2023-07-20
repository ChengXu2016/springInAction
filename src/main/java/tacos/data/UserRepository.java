package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.UserPO;

public interface UserRepository extends CrudRepository<UserPO, Long> {


    //    @Query("select * from user where username = :username")
    UserPO findByUsername(String username);
}
