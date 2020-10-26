package rmi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rmi.comon.Greeter;

import javax.annotation.PostConstruct;

@Component
public class TalkingRobot {
    @Autowired
    private Greeter greeter;

    @PostConstruct
    public void speak(){
        System.out.println("bla bla bla");
        System.out.println(greeter.getGreeting());
    }
}
