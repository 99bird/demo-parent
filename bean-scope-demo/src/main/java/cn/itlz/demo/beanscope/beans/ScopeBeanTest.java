package cn.itlz.demo.beanscope.beans;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/5 0005
 */
public class ScopeBeanTest {
    private String name;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ScopeBeanTest{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
