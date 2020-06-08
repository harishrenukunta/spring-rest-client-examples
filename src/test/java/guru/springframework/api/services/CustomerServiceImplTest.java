package guru.springframework.api.services;

import guru.springframework.api.TestConfig.TestConfig;
import guru.springframework.api.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void getCustomers() {
        final List<Customer> customers = customerService.getCustomers();
        assertThat(customers).as("Check customer are returned").isNotNull().hasSizeGreaterThan(0);

    }

    @Test
    void getCustomerById() {
        final List<Customer> customers = customerService.getCustomers();
        final Customer secondCustomer = customers.get(1);
        final String customerId = getCustomerIdFromUrl(secondCustomer.getCustomerUrl());
        final Customer customer = customerService.getCustomerById(Integer.parseInt(customerId));
        assertThat(customer)
                .isEqualToComparingOnlyGivenFields(secondCustomer, "firstname", "lastname");
    }

    @Test
    void addCustomer() {
        final Customer customerToBeAdded = new Customer();
        customerToBeAdded.setFirstname("Radhika");
        customerToBeAdded.setLastname("Renukunta");
        final Customer addedCustomer = customerService.addCustomer(customerToBeAdded);
        assertThat(addedCustomer)
                .isNotNull()
                .isEqualToComparingOnlyGivenFields(customerToBeAdded, "firstname", "lastname")
                .extracting("customerUrl")
                .isNotNull();
    }

    @Test
    void updateCustomer() {
        final Customer customerToBeAdded = new Customer();
        customerToBeAdded.setFirstname("Anil");
        customerToBeAdded.setLastname("Ravipudi");
        final Customer addedCustomer = customerService.addCustomer(customerToBeAdded);
        final String addedCustomerId = getCustomerIdFromUrl(addedCustomer.getCustomerUrl());
        assertThat(addedCustomerId).isNotNull();

        final Customer updateCustomer = new Customer();
        updateCustomer.setFirstname(addedCustomer.getFirstname() + "-Changed");
        updateCustomer.setLastname(addedCustomer.getLastname() + "-Changed");
        final ResponseEntity<Customer> updatedCustomerResponse = customerService.updateCustomer(addedCustomerId, updateCustomer);
        assertThat(updatedCustomerResponse.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
        final Customer updatedCustomer = updatedCustomerResponse.getBody();
        assertThat(updatedCustomer)
                .isEqualToComparingOnlyGivenFields(updatedCustomer, "firstname", "lastname");

    }

    @Test
    void deleteCustomerById() {
        final Customer customerToBeAdded = new Customer();
        customerToBeAdded.setFirstname("Sachin");
        customerToBeAdded.setLastname("Tendulkar");
        final Customer addedCustomer = customerService.addCustomer(customerToBeAdded);
        assertThat(addedCustomer).isEqualToComparingOnlyGivenFields(customerToBeAdded, "firstname", "lastname");
        final String addedCustomerId = getCustomerIdFromUrl(addedCustomer.getCustomerUrl());

        final ResponseEntity<Void> deleteCustomerResponse = customerService.deleteCustomerById(Integer.parseInt(addedCustomerId));
        assertThat(deleteCustomerResponse.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

    }

    private String getCustomerIdFromUrl(final String url){
        Pattern custIdPattern = Pattern.compile(".*/(\\d+)$");
        Matcher customerMatcher = custIdPattern.matcher(url);
        String id = null;
        if(customerMatcher.find()){
            id = customerMatcher.group(1);
        }
        return id;
    }
}