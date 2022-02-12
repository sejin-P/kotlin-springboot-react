package park.sejin.kotlrinspringbootreact.model

import javax.persistence.*

@Entity
@Table(name="employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name="first_name")
    var firstName: String,
    @Column(name="last_name")
    var lastName: String,
    @Column(name="email_id")
    var emailId: String,
) {
}
