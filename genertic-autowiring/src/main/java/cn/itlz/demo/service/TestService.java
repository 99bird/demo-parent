package cn.itlz.demo.service;

import cn.itlz.demo.support.FirstSon;
import cn.itlz.demo.support.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 这个类里面有一个带参构造方法，当FirstSon也是Spring中的Bean的时候，那么这个构造方法的参数会
 *       被自动注入到成员变量中，就相当于省略了@Autowire注解
 * @author Liuzd
 * Date: 2018/11/13 0013
 */
@Service
public class TestService {

    private FirstSon firstSon;

    public TestService(FirstSon firstSon) {
        this.firstSon = firstSon;
    }

    private List<Parent> sons;

    @Autowired
    public void setSons(List<Parent> sons) {
        this.sons = sons;
    }

    public List<Parent> getSons() {
        return sons;
    }

    public String getFirstSon() {
        firstSon.say();
        return "firstSon is invoked";
    }
}
