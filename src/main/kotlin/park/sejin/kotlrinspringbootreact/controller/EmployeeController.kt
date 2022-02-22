package park.sejin.kotlrinspringbootreact.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import park.sejin.kotlrinspringbootreact.httpModel.CreateEmployeeRequest
import park.sejin.kotlrinspringbootreact.httpModel.CreateEmployeeResponse
import park.sejin.kotlrinspringbootreact.model.Employee
import park.sejin.kotlrinspringbootreact.repository.EmployeeRepository
import java.net.http.HttpResponse

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
        createEmployeeRequest: CreateEmployeeRequest
    ): ResponseEntity<CreateEmployeeResponse> {
        val employee: Employee = Employee(
            firstName = createEmployeeRequest.firstName,
            lastName = createEmployeeRequest.lastName,
            emailId = createEmployeeRequest.emailId,
        )

        try {
            employeeRepository.save(
                employee
            )
        } catch (e: Exception) {
            return ResponseEntity.internalServerError().body(
                null
            )
        }

        return ResponseEntity.ok(
            CreateEmployeeResponse()
        )

    }
}