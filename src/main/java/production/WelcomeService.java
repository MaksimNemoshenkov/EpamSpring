package production;

import org.springframework.stereotype.Component;

@Component("1")
public class WelcomeService implements DeliveryService {
    @Override
    public void deliverDocument() {
        System.out.println("Welcome");
    }
}
