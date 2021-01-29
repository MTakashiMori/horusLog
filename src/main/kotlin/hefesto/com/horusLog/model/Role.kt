package hefesto.com.horusLog.model;

import javax.persistence.*

@Entity
class Role(

        @Id
        @GeneratedValue
        private var id: Long = 0,

        var name: String
)