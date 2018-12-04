package cn.itlz.demo.container.el;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * 在这个类的成员变量list中使用el表达式注入
 * @author Liuzd QQ: 77822013
 * @since 2018/11/21 0021
 */
public class InjectList {

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    @Autowired
    public void setList(@Value("#{@testValue.getList()}") List<String> list) {
        this.list = list;
    }

    public InjectList(List<String> list) {
        this.list = list;
    }

    public InjectList() {
    }
}
