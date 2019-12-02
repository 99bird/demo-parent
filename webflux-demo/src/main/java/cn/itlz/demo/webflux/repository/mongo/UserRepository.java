package cn.itlz.demo.webflux.repository.mongo;

import cn.itlz.demo.webflux.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
public interface UserRepository extends ReactiveCrudRepository<User,String> {

    Mono<User> findByUserName(String userName);

    Mono<User> deleteByUserName(String userName);
}
