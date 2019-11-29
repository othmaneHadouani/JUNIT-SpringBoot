package org.sid.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        Employee employee = new Employee(null,"Taoufiq");
        testEntityManager.persist(employee);
        testEntityManager.flush();

        Employee founded = employeeRepository.findByName(employee.getName());

        assertThat(founded.getName()).isEqualTo("hello");
    }
}
