package rmi.server;

import org.springframework.stereotype.Component;
import rmi.comon.Greeter;
@Component
public class RomanianGreeter implements Greeter {
    @Override
    public String getGreeting() {
        return "Hello my dear friend!";
    }
}
