package park.sejin.kotlrinspringbootreact.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
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

    //TODO better and secure response
    @PostMapping("/employees")
    fun createEmployee(
        @RequestBody
        employee: Employee
    ): Employee {
        return employeeRepository.save(employee)
    }

    //TODO exception handling better
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

    @PutMapping("/employees/{id}")
    fun updateEmployee(
        @PathVariable
        id: Long,
        @RequestBody
        employeeInfo: Employee,
    ): ResponseEntity<Employee> {
        val employee: Employee
        try {
            employee = employeeRepository.getById(id)
        } catch (e: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "employee $id")
        }

        employee.apply {
            this.firstName = employeeInfo.firstName
            this.lastName = employeeInfo.lastName
            this.emailId = employeeInfo.emailId
        }

        val updatedEmployee = employeeRepository.save(employee)
        return ResponseEntity.ok(updatedEmployee)
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(
        @PathVariable
        id: Long,
    ): ResponseEntity<Map<String, Boolean>> {
        val employee: Employee
        try {
            employeeRepository.deleteById(id)
        } catch (e: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "employee $id")
        }

        return ResponseEntity.ok(hashMapOf("deleted" to true))
    }
}
