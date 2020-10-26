package quoters;

import framework.PostInitialize;
import org.springframework.stereotype.Component;

@Component
public class RussianFilmsQuoter implements Quoter {
    @Override
    @PostInitialize
    public void sayQuote() {
        System.out.println("Москва слезам не верит");
    }
}
