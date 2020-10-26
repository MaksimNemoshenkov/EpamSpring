package quoters;

import framework.PostInitialize;
import org.springframework.stereotype.Component;

@Component
public class CacheProviderImpl implements CacheProvider {
    @Override
    @PostInitialize
    public void warmCache() {
        System.out.println("Warming cache");
    }
}