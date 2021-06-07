package hefesto.com.horusLog.controller

import hefesto.com.horusLog.model.Vehicle
import hefesto.com.horusLog.repository.VehicleRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/vehicle")
class VehicleController(private val repository: VehicleRepository)
{

    @GetMapping("/")
    fun all(): MutableList<Vehicle> {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): Optional<Vehicle> {
        return repository.findById(id);
    }

    @PostMapping("/")
    fun create(@RequestBody newVehicle: Vehicle): Vehicle {
        return repository.save(newVehicle);
    }

    @PutMapping("/{id}")
    fun update(@RequestBody newVehicle: Vehicle, @PathVariable id: Long): Optional<Vehicle>? {
        return repository.findById(id)
                .map { v: Vehicle ->
                    v.name = newVehicle.name;
                    v.capacity = newVehicle.capacity;
                    repository.save(v);
                }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return repository.deleteById(id);
    }

}