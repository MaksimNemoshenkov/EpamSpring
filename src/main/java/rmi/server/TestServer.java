package rmi.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestServer {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("rmi.server");
    }
}
