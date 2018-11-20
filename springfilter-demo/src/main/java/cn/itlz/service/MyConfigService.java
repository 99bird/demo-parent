package cn.itlz.service;

/**
 * @author Liuzd
 * @since 2018/11/19 0019
 */
public class MyConfigService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyConfigService{" +
                "name='" + name + '\'' +
                '}';
    }
}
