
package guru.springframework.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Employee {

    private String id;
    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private String employeeSalary;

    @JsonProperty("employee_age")
    private String employeeAge;

    @JsonProperty("profile_image")
    private String profileImage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee withId(String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee withEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Employee withEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
        return this;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Employee withEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Employee withProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

}
