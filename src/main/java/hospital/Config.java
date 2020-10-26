package hospital;


import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "hospital")
public class Config {
    @Bean
    public Surgeon vasyliyStepanov(){
        return new SurgeonImpl();
    }
    @Bean
    public Surgeon ivanIvanov(){
        return new SurgeonImpl();
    }
    @Bean
    public Assistant assistant(){
        return new AssistantImpl(){
            @Override
            public Pickle getPickle() {
                return pickle();
            }
        };
    }
    @Bean
    public Scalpel scalpel(){
        return new ScalpelImpl();
    }
    @Bean
    public Alcohol alcohol(){
        return new AlcoholImpl();
    }
    @Bean
    @Scope("prototype")
    public Pickle pickle(){
        return new PickleImpl();
    }
}
