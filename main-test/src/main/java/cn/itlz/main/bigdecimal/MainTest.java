package cn.itlz.main.bigdecimal;

import java.math.BigDecimal;

/**
 * @author Liuzd QQ: 77822013 2019/3/13 0013
 */
public class MainTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("3.3");
        BigDecimal bigDecimal1 = new BigDecimal("2");
        System.out.println(bigDecimal.divide(bigDecimal1));
    }
}
