package guru.springframework.api.services;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.api.domain.Customer;
import guru.springframework.api.domain.CustomerResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private String CUSTOMER_ROOT_URL = "https://api.predic8.de:443/shop/customers/";
    private final RestTemplate restTemplate;

    public CustomerServiceImpl(final RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }

    public List<Customer> getCustomers(){
        final CustomerResponse customerResponse = restTemplate.getForObject(CUSTOMER_ROOT_URL,CustomerResponse.class);
        return customerResponse.getCustomers();
    }


    public Customer getCustomerById(final int customerId){
        final String URL = UriComponentsBuilder.fromUriString(CUSTOMER_ROOT_URL).path("/{custId}").buildAndExpand(customerId).toUriString();
        final Customer customer = restTemplate.getForObject(URL, Customer.class);
        return customer;
    }

    @Override
    public Customer addCustomer(final Customer customer) {
        final Customer addedCustomer = restTemplate.postForObject(CUSTOMER_ROOT_URL, customer, Customer.class);
        return addedCustomer;
    }

    public ResponseEntity<Customer> updateCustomer(final String customerId, final Customer newCustomer){
        final String URL = UriComponentsBuilder.fromUriString(CUSTOMER_ROOT_URL).path("/{custId}").buildAndExpand(customerId).toUriString();
        return restTemplate.exchange(URL, HttpMethod.PUT,new HttpEntity<Customer>(newCustomer),Customer.class);
    }

    public ResponseEntity<Void> deleteCustomerById(final int customerId){
        final String URL = UriComponentsBuilder.fromUriString(CUSTOMER_ROOT_URL).path("/{custId}").buildAndExpand(customerId).toUriString();
        return restTemplate.exchange(URL,HttpMethod.DELETE,null,Void.class);
    }
}
