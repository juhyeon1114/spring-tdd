package study.spring_tdd;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

/**
 * Not used
 * - Jpa 사용할 때는 Datasource에 설정된 정보로 Container를 생성하므로, 이 클래스는 사용하지 않음
 */
@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

    @Container
    public static MySQLContainer MYSQL_CONTAINER = new MySQLContainer("mysql:8.4.1")
            .withDatabaseName("tc_test")
            .withUsername("root")
            .withPassword("1234");

}
