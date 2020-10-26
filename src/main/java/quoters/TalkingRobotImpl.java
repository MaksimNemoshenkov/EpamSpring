package quoters;

import framework.Benchmark;
import framework.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

    @Transaction
    @Component
public class    TalkingRobotImpl implements TalkingRobot{
        @Autowired
    private List<Quoter> quoters;

    @Override
    @Benchmark
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }
}
