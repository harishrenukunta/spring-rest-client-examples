package guru.springframework.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerResponse {
    private List<Customer> customers;

     public List<Customer> getCustomers() {
          return customers;
     }

     public void setCustomers(List<Customer> customers) {
          this.customers = customers;
     }
}
