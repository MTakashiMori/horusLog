package hefesto.com.horusLog.repository

import hefesto.com.horusLog.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long>