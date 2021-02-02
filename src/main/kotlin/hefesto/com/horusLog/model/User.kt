package hefesto.com.horusLog.model

import javax.persistence.*

@Entity
@Table(name="users")
class User (
        @Id
        @GeneratedValue
        private val id: Long,

        var name: String,

        var mail: String
)



