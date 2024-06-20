package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.personal.dhario.videojuegos.Entities.Users;
import proyecto.personal.dhario.videojuegos.Repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;

    @GetMapping
    public String getUsers(Model model) {
        List<Users> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "users"; // Nombre de la plantilla Thymeleaf para listar usuarios
    }

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable Integer id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("error", "Usuario no encontrado");
        }
        return "detalleUsuario"; // Nombre de la plantilla Thymeleaf para mostrar detalles de usuario
    }

    @GetMapping("/crear")
    public String crearUsuarioForm(Model model) {
        model.addAttribute("user", new Users());
        return "crearUsuario"; // Nombre de la plantilla Thymeleaf para crear un nuevo usuario
    }

    @PostMapping("/crear")
    public String crearUsuario(Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuarioForm(Model model, @PathVariable Integer id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "editarUsuario"; // Nombre de la plantilla Thymeleaf para editar usuario
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "redirect:/users";
        }
    }

    @PostMapping("/editar")
    public String editarUsuario(Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
