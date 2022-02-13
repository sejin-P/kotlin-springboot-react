package park.sejin.kotlrinspringbootreact.model

import javax.persistence.*

@Entity
@Table(name="employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long,
    @Column(name="first_name")
    private var firstName: String,
    @Column(name="last_name")
    private var lastName: String,
    @Column(name="email_id")
    private var emailId: String,
) {
}
