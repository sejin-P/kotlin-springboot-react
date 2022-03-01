package park.sejin.kotlrinspringbootreact.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import park.sejin.kotlrinspringbootreact.exception.ResourceNotFoundException
import park.sejin.kotlrinspringbootreact.model.Employee
import park.sejin.kotlrinspringbootreact.repository.EmployeeRepository
import javax.persistence.EntityNotFoundException

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

    @GetMapping("/employees/{id}")
    fun getEmployee(
        @PathVariable id: Long
    ): ResponseEntity<Employee> {
        try {
            val employee = employeeRepository.getById(id)
            return ResponseEntity.ok(employee)
        } catch (e: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "employee $id")
        }
    }
}