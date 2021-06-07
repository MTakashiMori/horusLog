package hefesto.com.horusLog.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
@Table(name="vehicles")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Vehicle(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var name: String,

        var capacity: String,

        @ManyToMany(mappedBy = "vehicles")
        var users: List<User> = mutableListOf()
)
