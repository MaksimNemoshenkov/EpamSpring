package aspects.prostotak;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public Integer work() {
            System.out.println("I'm very hard working...");
            return 41;
    }
}
