package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewQuoter implements Quoter{
    @Value("${NewQuoter}")
        private String message;

    @Override
    public void sayQuote() {

    }
}
