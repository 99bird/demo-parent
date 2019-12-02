package cn.itlz.demo.webflux.service;

import cn.itlz.demo.webflux.entity.User;
import cn.itlz.demo.webflux.repository.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> delete(String userNaem) {
        return userRepository.deleteByUserName(userNaem);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
