package com.example.EmployeeManager;

   import com.example.EmployeeManager.model.Employee;
   import com.example.EmployeeManager.service.EmployeeService;
   import org.junit.jupiter.api.BeforeEach;
   import org.junit.jupiter.api.Test;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;
   import org.mockito.MockitoAnnotations;
   import org.springframework.boot.test.context.SpringBootTest;
   import org.springframework.boot.test.mock.mockito.MockBean;

   import java.util.Arrays;
   import java.util.List;
   import java.util.Optional;

   import static org.junit.jupiter.api.Assertions.*;
   import static org.mockito.Mockito.*;

   @SpringBootTest
   public class EmployeeManagerApplicationE2ETests {

       @MockBean
       private EmployeeService employeeService;

       @BeforeEach
       public void setup() {
           MockitoAnnotations.openMocks(this);
       }

       @Test
       public void testGetAllEmployees() {
           Employee employee1 = new Employee("John Doe", "john.doe@example.com", "Software Engineer", "1234567890", "imageUrl", "EMP001");
           Employee employee2 = new Employee("Jane Doe", "jane.doe@example.com", "Product Manager", "0987654321", "imageUrl", "EMP002");
           when(employeeService.findAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

           List<Employee> employees = employeeService.findAllEmployees();
           assertEquals(2, employees.size());
           verify(employeeService, times(1)).findAllEmployees();
       }

       @Test
       public void testAddEmployee() {
           Employee employee = new Employee("John Doe", "john.doe@example.com", "Software Engineer", "1234567890", "imageUrl", "EMP001");
           when(employeeService.addEmployee(employee)).thenReturn(employee);

           Employee addedEmployee = employeeService.addEmployee(employee);
           assertEquals(employee, addedEmployee);
           verify(employeeService, times(1)).addEmployee(employee);
       }

       @Test
       public void testUpdateEmployee() {
           Employee employee = new Employee("John Doe", "john.doe@example.com", "Software Engineer", "1234567890", "imageUrl", "EMP001");
           when(employeeService.updateEmployee(employee)).thenReturn(employee);

           Employee updatedEmployee = employeeService.updateEmployee(employee);
           assertEquals(employee, updatedEmployee);
           verify(employeeService, times(1)).updateEmployee(employee);
       }

       @Test
       public void testDeleteEmployee() {
           doNothing().when(employeeService).deleteEmployee(1L);

           employeeService.deleteEmployee(1L);
           verify(employeeService, times(1)).deleteEmployee(1L);
       }

       @Test
       public void testFindEmployeeById() {
           Employee employee = new Employee("John Doe", "john.doe@example.com", "Software Engineer", "1234567890", "imageUrl", "EMP001");
           when(employeeService.findEmployeeById(1L)).thenReturn(employee);

           Employee foundEmployee = employeeService.findEmployeeById(1L);
           assertEquals(employee, foundEmployee);
           verify(employeeService, times(1)).findEmployeeById(1L);
       }
   }