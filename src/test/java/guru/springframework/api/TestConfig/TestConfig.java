package guru.springframework.api.TestConfig;

import guru.springframework.api.services.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@TestConfiguration
public class TestConfig {

    @Bean
    public EmployeeService employeeService(final RestTemplate restTemplate){
        return new EmployeeServiceImpl(restTemplate);
    }

    @Bean
    public CategoryService categoryService(final RestTemplate restTemplate){
        return new CategoryServiceImpl(restTemplate);
    }

    @Bean
    public CustomerService customerService(final RestTemplate restTemplate){
        return new CustomerServiceImpl(restTemplate);

    }
}
