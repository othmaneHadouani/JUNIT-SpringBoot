package org.sid.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.sid.dao.EmployeeRepository;
import org.sid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {


    @TestConfiguration
    static class EmployeeServiceImplTestConfiguration {
        @Bean
        public EmployeeService employeeService(){
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;


    @BeforeEach
    public void setUp() {
        Employee employee = new Employee(null, "bahalla");
        Mockito.when(employeeRepository.findByName(employee.getName())).thenReturn(employee);
    }
    @Test
    public void whenValidName_thenEmployeeShouldBeReturned() {

        String name = "bahalla";
        Employee p = employeeService.findEmployeeByName(name);

        assertThat(p.getName()).isEqualTo(name);

    }
}
