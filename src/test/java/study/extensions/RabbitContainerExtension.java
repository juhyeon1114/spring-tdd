package study.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class RabbitContainerExtension implements Extension, BeforeAllCallback, AfterAllCallback {

    @Container
    static GenericContainer rabbitmq = new GenericContainer(DockerImageName.parse("rabbitmq:3.13.6-management"))
            .withExposedPorts(5672);

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        rabbitmq.start();
        System.setProperty("spring.rabbitmq.port", String.valueOf(rabbitmq.getFirstMappedPort()));
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        rabbitmq.stop();
    }

}
