package guru.springframework.api.services;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.api.domain.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer getCustomerById(final int customerId);
    public Customer addCustomer(final Customer customer);
    public ResponseEntity<Customer> updateCustomer(final String customerId, final Customer newCustomer);
    public ResponseEntity<Void> deleteCustomerById(final int customerId);
}
