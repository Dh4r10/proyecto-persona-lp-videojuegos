package proyecto.personal.dhario.videojuegos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.personal.dhario.videojuegos.Entities.Disponible;
import proyecto.personal.dhario.videojuegos.Repositories.DisponibleRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/disponible")
public class DisponibleController {

    @Autowired
    private DisponibleRepository disponibleRepository;

    @GetMapping
    public String getDisponibles(Model model) {
        List<Disponible> disponibleLista = disponibleRepository.findAll();
        model.addAttribute("disponibles", disponibleLista);
        return "disponibles"; // el nombre de tu plantilla Thymeleaf para listar disponibles
    }

    @GetMapping("/{id}")
    public String getDisponibleById(Model model, @PathVariable Integer id) {
        Optional<Disponible> disponible = disponibleRepository.findById(id);
        if (disponible.isPresent()) {
            model.addAttribute("disponible", disponible.get());
        } else {
            model.addAttribute("error", "Disponible no encontrado");
        }
        return "detalleDisponible"; // el nombre de tu plantilla Thymeleaf para mostrar detalles de disponible
    }

    @PostMapping("/crear")
    public String crearDisponible(Disponible disponible) {
        disponibleRepository.save(disponible);
        return "redirect:/disponible";
    }

    @GetMapping("/editar/{id}")
    public String editarDisponibleForm(Model model, @PathVariable Integer id) {
        Optional<Disponible> disponible = disponibleRepository.findById(id);
        if (disponible.isPresent()) {
            model.addAttribute("disponible", disponible.get());
            return "editarDisponible"; // el nombre de tu plantilla Thymeleaf para editar disponible
        } else {
            model.addAttribute("error", "Disponible no encontrado");
            return "redirect:/disponible";
        }
    }

    @PostMapping("/editar")
    public String editarDisponible(Disponible disponible) {
        disponibleRepository.save(disponible);
        return "redirect:/disponible";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarDisponible(@PathVariable Integer id) {
        disponibleRepository.deleteById(id);
        return "redirect:/disponible";
    }
}
