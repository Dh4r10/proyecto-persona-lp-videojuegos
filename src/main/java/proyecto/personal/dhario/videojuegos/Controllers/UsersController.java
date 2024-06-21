package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.personal.dhario.videojuegos.Entities.Roles;
import proyecto.personal.dhario.videojuegos.Entities.Users;
import proyecto.personal.dhario.videojuegos.Repositories.RolesRepository;
import proyecto.personal.dhario.videojuegos.Repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public String getUsers(Model model) {
        List<Users> userLista = userRepository.findAll();
        model.addAttribute("users", userLista);
        model.addAttribute("usersForm", new Users());

        List<Roles> rolesLista = rolesRepository.findAll();
        model.addAttribute("rolesSelect", rolesLista);

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

    @PostMapping("/users-create")
    public String crearUsuario(Users user) {
        var BcryptPasswordEncoder = new BCryptPasswordEncoder();

        Users newUser = new Users();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(BcryptPasswordEncoder.encode(user.getPassword()));
        newUser.setRoles(user.getRoles());
        newUser.setEmail(user.getEmail());
        newUser.setNombre(user.getNombre());
        newUser.setApellidoPaterno(user.getApellidoPaterno());
        newUser.setApellidoMaterno(user.getApellidoMaterno());
        newUser.setFechaNacimiento(user.getFechaNacimiento());
        newUser.setActivo(true);

        userRepository.save(newUser);
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

    @RequestMapping("/eliminar-user/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
