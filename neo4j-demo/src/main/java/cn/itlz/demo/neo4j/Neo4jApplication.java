package cn.itlz.demo.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author Liuzd QQ: 77822013 2019/5/30 0030
 */
@SpringBootApplication
@EnableNeo4jRepositories("cn.itlz.demo.neo4j.repository")
@EntityScan(basePackages = "cn.itlz.demo.neo4j.domain")
public class Neo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }
}
