package hefesto.com.horusLog.repository

import hefesto.com.horusLog.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>