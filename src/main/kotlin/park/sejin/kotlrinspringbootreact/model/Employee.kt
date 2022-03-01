package park.sejin.kotlrinspringbootreact.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name="employees")
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @JsonProperty("first_name")
    @Column(name="first_name")
    val firstName: String,
    @JsonProperty("last_name")
    @Column(name="last_name")
    val lastName: String,
    @JsonProperty("email_id")
    @Column(name="email_id")
    val emailId: String,
) {
}
