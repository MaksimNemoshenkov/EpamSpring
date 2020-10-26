package rmi.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import rmi.comon.Greeter;

@Configuration
public class ServerConfig {
    @Bean
    public RmiServiceExporter exporter(Greeter greeter){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(greeter);
        rmiServiceExporter.setServiceName("Greeter123");
        rmiServiceExporter.setServiceInterface(Greeter.class);
        return rmiServiceExporter;
    }
}