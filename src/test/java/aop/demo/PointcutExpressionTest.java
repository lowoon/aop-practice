package aop.demo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

public class PointcutExpressionTest {
    @Test
    void methodSignaturePointcut() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public int " +
            "aop.demo.Target.minus(int,int) " +
            "throws java.lang.RuntimeException)");

        assertThat(pointcut.getClassFilter().matches(Target.class) && pointcut.getMethodMatcher()
            .matches(Target.class.getMethod("minus", int.class, int.class), null)).isTrue();
    }
}
