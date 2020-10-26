package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OldQuoter implements Quoter {
    @Value("${OldQuoter}")
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
