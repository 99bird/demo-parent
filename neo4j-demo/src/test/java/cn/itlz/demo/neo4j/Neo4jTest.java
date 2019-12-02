package cn.itlz.demo.neo4j;

import cn.itlz.demo.neo4j.domain.Person;
import cn.itlz.demo.neo4j.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Liuzd <QQ: 77822013> 2019/5/30 0030
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Neo4jTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        Person person = new Person();
        person.setAge(23);
        person.setName("李四");
        personRepository.save(person);
    }
}
