package park.sejin.kotlrinspringbootreact.model

import javax.persistence.*

@Entity
@Table(name="employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name="first_name")
    val firstName: String,
    @Column(name="last_name")
    val lastName: String,
    @Column(name="email_id")
    val emailId: String,
) {
}
