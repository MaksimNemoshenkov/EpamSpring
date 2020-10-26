package quoters;

import framework.MyDeprecated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TerminatorQuoter implements Quoter{

    private List<String> messages;

    @Value("${terminatorQuotes}")
    public void setList(String[] messages) {
        this.messages = Arrays.asList(messages);
    }

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println("message = " + message);
        }
    }
}
