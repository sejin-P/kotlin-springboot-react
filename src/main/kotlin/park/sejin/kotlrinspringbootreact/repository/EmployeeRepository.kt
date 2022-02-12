package park.sejin.kotlrinspringbootreact.repository

import org.springframework.data.jpa.repository.JpaRepository
import park.sejin.kotlrinspringbootreact.model.Employee

interface EmployeeRepository: JpaRepository<Employee, Long> {

}