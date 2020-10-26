package hospital;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestHospital {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Surgeon vasyliyStepanov = (Surgeon) context.getBean("vasyliyStepanov");
        Surgeon ivanIvanov = (Surgeon) context.getBean("ivanIvanov");
        vasyliyStepanov.operate();
        System.out.println("*********************");
        ivanIvanov.operate();
    }
}
