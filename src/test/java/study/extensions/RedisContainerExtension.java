package study.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class RedisContainerExtension implements Extension, BeforeAllCallback, AfterAllCallback {

    @Container
    static GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:7.2.5"))
            .withExposedPorts(6379);

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        redis.start();
        System.setProperty("spring.data.redis.port", String.valueOf(redis.getFirstMappedPort()));
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        redis.stop();
    }

}
