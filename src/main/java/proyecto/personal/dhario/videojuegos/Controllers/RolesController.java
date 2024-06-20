package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.personal.dhario.videojuegos.Entities.Roles;
import proyecto.personal.dhario.videojuegos.Repositories.RolesRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public String getRoles(Model model) {
        List<Roles> roles = rolesRepository.findAll();
        model.addAttribute("roles", roles);
        return "roles/listaRoles"; // Nombre de la plantilla Thymeleaf para listar roles
    }

    @GetMapping("/crear")
    public String crearRoleForm(Model model) {
        model.addAttribute("roles", new Roles());
        return "roles/crearRoles"; // Nombre de la plantilla Thymeleaf para crear un nuevo role
    }

    @PostMapping("/crear")
    public String crearRole(Roles roles) {
        rolesRepository.save(roles);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String editarRoleForm(Model model, @PathVariable Integer id) {
        Optional<Roles> roles = rolesRepository.findById(id);
        if (roles.isPresent()) {
            model.addAttribute("roles", roles.get());
            return "roles/editarRoles"; // Nombre de la plantilla Thymeleaf para editar un role
        } else {
            model.addAttribute("error", "Roles no encontrados");
            return "redirect:/roles";
        }
    }

    @PostMapping("/editar")
    public String editarRole(Roles roles) {
        rolesRepository.save(roles);
        return "redirect:/roles";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarRole(@PathVariable Integer id) {
        rolesRepository.deleteById(id);
        return "redirect:/roles";
    }
}
