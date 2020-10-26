package colors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for (int i = 0; i<50; i++){
            try {
                Thread.sleep(100);
                ColoredFrame coloredFrame = context.getBean(ColoredFrame.class);
                coloredFrame.showOnRandomPlace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}