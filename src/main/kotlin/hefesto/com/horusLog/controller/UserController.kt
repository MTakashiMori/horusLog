package hefesto.com.horusLog.controller

import hefesto.com.horusLog.model.User
import hefesto.com.horusLog.model.Vehicle
import hefesto.com.horusLog.repository.UserRepository
import hefesto.com.horusLog.repository.VehicleRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository, private val vehicleRepository: VehicleRepository)
{

    @GetMapping("/")
    fun all(): MutableIterable<User> {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): Optional<User> {
        return repository.findById(id);
    }

    @PostMapping("/")
    fun create(@RequestBody newUser: User): User {
        return repository.save(newUser);
    }

    @PostMapping("/{id}/add-vehicle")
    fun addVehicles(@PathVariable id: Long, @RequestBody vehicles: Array<Long>): User {
        val user = repository.findById(id).get();
        val vehicleList = mutableListOf<Vehicle>();
        for(vehicle_id in vehicles ) {
            vehicleList.add(vehicleRepository.findById(vehicle_id).get())
        }
        user.vehicles = vehicleList;
        return repository.save(user);
    }

    @PutMapping("/{id}")
    fun update(@RequestBody newUser: User, @PathVariable id: Long): Optional<User> {
        return repository.findById(id)
            .map { u: User ->
                u.name = newUser.name;
                u.mail = newUser.mail;
                repository.save(u)
            }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return repository.deleteById(id);
    }

}