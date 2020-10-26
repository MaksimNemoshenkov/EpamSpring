package production;

import org.springframework.stereotype.Service;

@Service("3")
public class TaxesDeliveryService implements DeliveryService {
    @Override
    public void deliverDocument() {
        System.out.println("Taxes Service");
    }
}
