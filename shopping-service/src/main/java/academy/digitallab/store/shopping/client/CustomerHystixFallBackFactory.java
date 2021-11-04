package academy.digitallab.store.shopping.client;

import academy.digitallab.store.shopping.model.Customer;
import org.springframework.http.ResponseEntity;

public class CustomerHystixFallBackFactory implements CustomerClient{

    @Override
    public ResponseEntity<Customer> getCustomer(long id) {
        Customer customer = Customer.builder().firstName("none")
                .lastName("none").email("none").photoUrl("none").build();
        return ResponseEntity.ok(customer);
    }

}
