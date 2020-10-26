package rmi.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClient {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("rmi.client");
    }
}
