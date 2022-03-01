package park.sejin.kotlrinspringbootreact.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import park.sejin.kotlrinspringbootreact.model.Employee
import park.sejin.kotlrinspringbootreact.repository.EmployeeRepository

@CrossOrigin(origins = ["http://localhost:3000"])
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

    @PostMapping("/employees")
    fun createEmployee(
        @RequestBody
        employee: Employee
    ): Employee {
        return employeeRepository.save(employee)
    }
}