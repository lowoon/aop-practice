package aop.demo;

import org.springframework.context.annotation.Import;

@Import(SqlService.class)
public @interface EnableSqlService {
}
