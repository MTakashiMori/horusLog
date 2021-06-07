package hefesto.com.horusLog.repository

import hefesto.com.horusLog.model.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository: JpaRepository<Vehicle, Long>