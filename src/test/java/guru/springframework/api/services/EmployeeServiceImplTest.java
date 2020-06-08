package guru.springframework.api.services;

import guru.springframework.api.TestConfig.TestConfig;
import guru.springframework.api.config.RestTemplateConfig;
import guru.springframework.api.domain.Employee;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    void getEmployees() {
        final List<Employee> listOfEmployees = employeeService.getEmployees();
        assertThat(listOfEmployees).as("Check employees are returned").hasSizeGreaterThan(5);
    }
}