package production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MainDeliveryServiceImpl implements MainDeliveryService {
    @Autowired
    private Map<String, DeliveryService> map;
    @Override
    public void deliver(int deliveryType) {
        map.get(Integer.toString(deliveryType)).deliverDocument();
    }
}