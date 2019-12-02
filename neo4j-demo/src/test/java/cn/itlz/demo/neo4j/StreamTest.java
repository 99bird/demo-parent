package cn.itlz.demo.neo4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Liuzd <QQ: 77822013> 2019/6/2 0002
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class StreamTest {

    @Test
    public void test() {
        List<String> stringList = new ArrayList<>();
        stringList.add("sss");
        stringList.add("aaa");
        stringList.add("liuzd");

        Stream<String> stringStream = stringList.stream();
        stringStream.forEach(str -> str = str + "-liuzd");

        Stream<String> stream = stringList.stream().filter(str-> str.equals("liuzd"));

        stream.forEach(System.out::println);
    }
}
