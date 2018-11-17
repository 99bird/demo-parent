package cn.itlz.config;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/10 0010
 */
public class Test {

    private String hello;
    private String itlz;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getItlz() {
        return itlz;
    }

    public void setItlz(String itlz) {
        this.itlz = itlz;
    }

    @Override
    public String toString() {
        return "Test{" +
                "hello='" + hello + '\'' +
                ", itlz='" + itlz + '\'' +
                '}';
    }
}
