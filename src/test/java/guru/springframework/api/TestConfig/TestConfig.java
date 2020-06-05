package guru.springframework.api.TestConfig;

import guru.springframework.api.services.EmployeeService;
import guru.springframework.api.services.EmployeeServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@TestConfiguration
public class TestConfig {

    @Bean
    public EmployeeService employeeService(final RestTemplate restTemplate){
        return new EmployeeServiceImpl(restTemplate);
    }
}
