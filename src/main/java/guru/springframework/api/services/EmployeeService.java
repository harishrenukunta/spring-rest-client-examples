package guru.springframework.api.services;

import guru.springframework.api.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getEmployees();
}
