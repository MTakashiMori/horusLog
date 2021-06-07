package hefesto.com.horusLog.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
@Table(name="users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class User (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var name: String,

        var mail: String,

        @ManyToMany
        @JoinTable(
                name="user_vehicle",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "vehicle_id", referencedColumnName = "id")]
        )
        var vehicles: List<Vehicle> = mutableListOf()
)