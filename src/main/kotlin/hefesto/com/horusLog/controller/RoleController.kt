package hefesto.com.horusLog.controller

import hefesto.com.horusLog.model.Role
import hefesto.com.horusLog.repository.RoleRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/role")
class RoleController(private val repository: RoleRepository)
{

    @GetMapping("/")
    fun all(): MutableList<Role> {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): Optional<Role> {
        return repository.findById(id);
    }

    @PostMapping("/")
    fun create(@RequestBody role: Role): Role {
        return repository.save(role);
    }

    @PutMapping("/{id}")
    fun update(@RequestBody newRole: Role, @PathVariable id: Long): Optional<Role>? {
        return repository.findById(id)
            .map { r: Role ->
                r.name = newRole.name;
                repository.save(r);
            }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return repository.deleteById(id);
    }

}