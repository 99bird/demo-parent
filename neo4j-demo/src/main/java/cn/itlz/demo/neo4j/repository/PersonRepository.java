package cn.itlz.demo.neo4j.repository;

import cn.itlz.demo.neo4j.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Liuzd QQ: 77822013 2019/5/30 0030
 */
public interface PersonRepository extends Neo4jRepository<Person,Long> {
}
