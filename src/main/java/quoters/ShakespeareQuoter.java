package quoters;

import aspects.aop.DatabaseRuntimeException;
import framework.Benchmark;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShakespeareQuoter implements Quoter {
    @Value("${shakespeareQuote}")
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
        throw new DatabaseRuntimeException("fire all dba");
    }

}
