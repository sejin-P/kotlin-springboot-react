package park.sejin.kotlrinspringbootreact.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import park.sejin.kotlrinspringbootreact.model.Employee
import park.sejin.kotlrinspringbootreact.repository.EmployeeRepository

@RestController
@RequestMapping("/api/v1/")
class EmployeeController(
    @Autowired
    private val employeeRepository: EmployeeRepository
) {
    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }
}