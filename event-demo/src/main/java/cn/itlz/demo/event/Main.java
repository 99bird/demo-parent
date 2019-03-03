package cn.itlz.demo.event;

import java.util.Scanner;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/9 0009
 */
public class Main {
    public static void main(String[] args) {
        Value v = new Value();
        v.addChangeValueEventListener((changeValueEvent)->{
            System.out.println(changeValueEvent.getSource());
        });

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String value = scanner.nextLine();
            Integer val = Integer.valueOf(value);
            v.changeVal(val);
        }
    }
}
