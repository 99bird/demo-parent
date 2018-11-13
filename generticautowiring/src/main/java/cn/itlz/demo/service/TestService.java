package cn.itlz.demo.service;

import cn.itlz.demo.support.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/13 0013
 */
@Service
public class TestService {

    private List<Parent> sons;

    @Autowired
    public void setSons(List<Parent> sons) {
        this.sons = sons;
    }

    public List<Parent> getSons() {
        return sons;
    }
}
