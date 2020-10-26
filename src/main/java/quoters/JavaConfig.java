package quoters;

import aspects.aop.ExceptionHandingAspect;
import changer.ChangeDeprecatedClassAspect;
import framework.MyApplicationListener;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"quoters"})
@PropertySource("classpath:quotes.properties")
public class JavaConfig {
    @Bean
    public ExceptionHandingAspect aspect(){
        return new ExceptionHandingAspect();
    }
    @Bean
    public ChangeDeprecatedClassAspect aspectD(){
        return new ChangeDeprecatedClassAspect();
    }
    @Bean
    public MyApplicationListener listener(){
        return new MyApplicationListener();
    }
}