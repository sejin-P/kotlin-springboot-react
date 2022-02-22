package park.sejin.kotlrinspringbootreact.httpModel

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateEmployeeRequest(
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
    @JsonProperty("email_id")
    val emailId: String
)