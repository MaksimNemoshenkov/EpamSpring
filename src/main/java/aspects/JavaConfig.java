package aspects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import aspects.prostotak.MyService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"aspects/aop", "aspects/prostotak"})
public class JavaConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        context.getBean(MyService.class).work();
    }
}
