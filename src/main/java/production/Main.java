package production;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext("production");
        MainDeliveryService deliveryService = contex.getBean(MainDeliveryService.class);
        deliveryService.deliver(3);
    }
}
