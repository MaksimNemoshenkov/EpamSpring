package quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Collection;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Terminator terminator = context.getBean(TerminatorFactory.class).createTerminator();
        terminator.killSaraKonnor();
/*        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TalkingRobot talkingRobot = context.getBean(TalkingRobot.class);
        talkingRobot.talk();*/

      //  new ClassPathXmlApplicationContext("context.xml");
/*
    ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("context.xml");
    ShakespeareQuoter bean = context.getBean(ShakespeareQuoter.class);
    bean.sayQuote();

    Quoter bean1 = context.getBean("terminatorQuoter", TerminatorQuoter.class);
    bean1.sayQuote();

    Map<String, Quoter> map = context.getBeansOfType(Quoter.class);
        Collection<Quoter> quoters = map.values();
        for (Quoter quoter: quoters ) {
            quoter.sayQuote();
        }
        */
    }
}
