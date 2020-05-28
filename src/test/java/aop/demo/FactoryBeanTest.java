package aop.demo;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class FactoryBeanTest {
    @Autowired
    private ApplicationContext context;

    @Test
    void getMessageFromFactoryBean() {
        Object message = context.getAttributeNames();
        System.out.println(message);
    }
}