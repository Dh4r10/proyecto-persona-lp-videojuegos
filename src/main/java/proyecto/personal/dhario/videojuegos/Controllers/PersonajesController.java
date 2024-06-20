package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Personajes;
import proyecto.personal.dhario.videojuegos.Repositories.PersonajesRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/personajes")
public class PersonajesController {

    @Autowired
    private PersonajesRepository personajesRepository;

    @GetMapping
    public String getPersonajes(Model model) {
        List<Personajes> personajesLista = (List<Personajes>) personajesRepository.findAll();
        model.addAttribute("personajes", personajesLista);
        return "personajes"; // el nombre de tu plantilla Thymeleaf para listar personajes
    }

    @GetMapping("/{id}")
    public String getPersonajesById(Model model, @PathVariable Integer id) {
        Optional<Personajes> personajes = personajesRepository.findById(id);
        if (personajes.isPresent()) {
            model.addAttribute("personajes", personajes.get());
        } else {
            model.addAttribute("error", "Personajes no encontrado");
        }
        return "detallePersonajes"; // el nombre de tu plantilla Thymeleaf para mostrar detalles de personajes
    }

    @GetMapping("/crear")
    public String crearPersonajesForm(Model model) {
        model.addAttribute("personajes", new Personajes());
        return "crearPersonajes"; // el nombre de tu plantilla Thymeleaf para crear personajes
    }

    @PostMapping("/crear")
    public String crearPersonajes(Personajes personajes) {
        personajesRepository.save(personajes);
        return "redirect:/personajes";
    }

    @GetMapping("/editar/{id}")
    public String editarPersonajesForm(Model model, @PathVariable Integer id) {
        Optional<Personajes> personajes = personajesRepository.findById(id);
        if (personajes.isPresent()) {
            model.addAttribute("personajes", personajes.get());
            return "editarPersonajes"; // el nombre de tu plantilla Thymeleaf para editar personajes
        } else {
            model.addAttribute("error", "Personajes no encontrado");
            return "redirect:/personajes";
        }
    }

    @PostMapping("/editar")
    public String editarPersonajes(Personajes personajes) {
        personajesRepository.save(personajes);
        return "redirect:/personajes";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPersonajes(@PathVariable Integer id) {
        personajesRepository.deleteById(id);
        return "redirect:/personajes";
    }
}
