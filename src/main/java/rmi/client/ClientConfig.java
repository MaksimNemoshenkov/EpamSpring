package rmi.client;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import rmi.comon.Greeter;

@Configuration
public class ClientConfig {
    @Bean
    public Greeter greeter(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/Greeter123");
        rmiProxyFactoryBean.setServiceInterface(Greeter.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (Greeter) rmiProxyFactoryBean.getObject();
    }
}
