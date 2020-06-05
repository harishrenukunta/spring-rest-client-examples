package guru.springframework.api.services;

import guru.springframework.api.domain.Employee;
import guru.springframework.api.domain.EmployeeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate;
    @Value("${app.url}")
    private String appUrl;

    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> getEmployees() {
        final EmployeeResponse response = restTemplate.getForObject(appUrl, EmployeeResponse.class);
        return response.getData();
    }
}
