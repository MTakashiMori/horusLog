package hefesto.com.horusLog.controller

import hefesto.com.horusLog.model.User
import hefesto.com.horusLog.repository.UserRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository)
{

    @GetMapping("/")
    fun all(): List<User> {
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